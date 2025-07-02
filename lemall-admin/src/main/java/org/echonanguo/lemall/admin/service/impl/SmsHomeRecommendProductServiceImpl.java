package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.common.model.SmsHomeRecommendProduct;
import org.echonanguo.lemall.admin.mapper.SmsHomeRecommendProductMapper;
import org.echonanguo.lemall.admin.service.SmsHomeRecommendProductService;
import org.springframework.util.StringUtils;
/**
 * 首页人气推荐管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class SmsHomeRecommendProductServiceImpl extends ServiceImpl<SmsHomeRecommendProductMapper, SmsHomeRecommendProduct> implements SmsHomeRecommendProductService{
    @Override
    public int create(List<SmsHomeRecommendProduct> homeRecommendProductList) {
        for (SmsHomeRecommendProduct recommendProduct : homeRecommendProductList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            baseMapper.insert(recommendProduct);
        }
        return homeRecommendProductList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendProduct recommendProduct = new SmsHomeRecommendProduct();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return baseMapper.updateById(recommendProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        return baseMapper.delete(Wrappers.<SmsHomeRecommendProduct>lambdaQuery()
        .in(SmsHomeRecommendProduct::getId, ids)
        );
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendProduct record = new SmsHomeRecommendProduct();
        record.setRecommendStatus(recommendStatus);
        return baseMapper.update(record,Wrappers.<SmsHomeRecommendProduct>lambdaQuery()
                .in(SmsHomeRecommendProduct::getId, ids)
        );
    }

    @Override
    public List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        Page<SmsHomeRecommendProduct> page = new Page<>(pageNum, pageSize);

        return baseMapper.selectPage(page,Wrappers.<SmsHomeRecommendProduct>lambdaQuery()
                .like(StringUtils.hasText(productName),SmsHomeRecommendProduct::getProductName,productName)
                .eq(recommendStatus != null,SmsHomeRecommendProduct::getRecommendStatus,recommendStatus)
                .orderByDesc(SmsHomeRecommendProduct::getSort)
        ).getRecords();
    }
}
