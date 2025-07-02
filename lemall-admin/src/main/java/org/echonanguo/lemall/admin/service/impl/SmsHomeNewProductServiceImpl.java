package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.common.model.SmsHomeNewProduct;
import org.echonanguo.lemall.admin.mapper.SmsHomeNewProductMapper;
import org.echonanguo.lemall.admin.service.SmsHomeNewProductService;
import org.springframework.util.StringUtils;

/**
 * 首页新品推荐管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class SmsHomeNewProductServiceImpl extends ServiceImpl<SmsHomeNewProductMapper, SmsHomeNewProduct> implements SmsHomeNewProductService{
    @Override
    public int create(List<SmsHomeNewProduct> homeNewProductList) {
        for (SmsHomeNewProduct SmsHomeNewProduct : homeNewProductList) {
            SmsHomeNewProduct.setRecommendStatus(1);
            SmsHomeNewProduct.setSort(0);
            baseMapper.insert(SmsHomeNewProduct);
        }
        return homeNewProductList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeNewProduct homeNewProduct = new SmsHomeNewProduct();
        homeNewProduct.setId(id);
        homeNewProduct.setSort(sort);
        return baseMapper.updateById(homeNewProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        return baseMapper.delete(Wrappers.<SmsHomeNewProduct>lambdaQuery()
                .in(SmsHomeNewProduct::getId, ids)
        );
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeNewProduct record = new SmsHomeNewProduct();
        record.setRecommendStatus(recommendStatus);
        return baseMapper.update(record,Wrappers.<SmsHomeNewProduct>lambdaQuery()
        .in(SmsHomeNewProduct::getId, ids));
    }

    @Override
    public List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        return baseMapper.selectPage(new Page<SmsHomeNewProduct>(pageNum,pageSize),
                Wrappers.<SmsHomeNewProduct>lambdaQuery()
                        .like(StringUtils.hasText(productName),SmsHomeNewProduct::getProductName,productName)
                        .eq(recommendStatus != null,SmsHomeNewProduct::getRecommendStatus,recommendStatus)
                        .orderByDesc(SmsHomeNewProduct::getSort))
                .getRecords();
    }
}
