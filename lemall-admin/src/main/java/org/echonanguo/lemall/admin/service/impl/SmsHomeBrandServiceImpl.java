package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.SmsHomeBrandMapper;
import org.echonanguo.lemall.common.model.SmsHomeBrand;
import org.echonanguo.lemall.admin.service.SmsHomeBrandService;
import org.springframework.util.StringUtils;

/**
 * 首页品牌管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class SmsHomeBrandServiceImpl extends ServiceImpl<SmsHomeBrandMapper, SmsHomeBrand> implements SmsHomeBrandService{
    @Override
    public int create(List<SmsHomeBrand> homeBrandList) {
        for (SmsHomeBrand smsHomeBrand : homeBrandList) {
            smsHomeBrand.setRecommendStatus(1);
            smsHomeBrand.setSort(0);
            baseMapper.insert(smsHomeBrand);
        }
        return homeBrandList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeBrand homeBrand = new SmsHomeBrand();
        homeBrand.setId(id);
        homeBrand.setSort(sort);
        return baseMapper.updateById(homeBrand);
    }

    @Override
    public int delete(List<Long> ids) {
        return baseMapper.delete(Wrappers.<SmsHomeBrand>lambdaQuery()
        .in(SmsHomeBrand::getId, ids)
        );
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {

        SmsHomeBrand record = new SmsHomeBrand();
        record.setRecommendStatus(recommendStatus);
        return baseMapper.update(record,Wrappers.<SmsHomeBrand>lambdaQuery()
        .in(SmsHomeBrand::getId, ids)
        );
    }

    @Override
    public List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        return baseMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<SmsHomeBrand>lambdaQuery()
                        .like(StringUtils.hasText(brandName), SmsHomeBrand::getBrandName, brandName)
                        .eq(recommendStatus!=null, SmsHomeBrand::getRecommendStatus, recommendStatus)
                        .orderByDesc(SmsHomeBrand::getSort))
                .getRecords();
    }
}
