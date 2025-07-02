package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.admin.mapper.SmsHomeRecommendSubjectMapper;
import org.echonanguo.lemall.common.model.SmsHomeRecommendSubject;
import org.echonanguo.lemall.admin.service.SmsHomeRecommendSubjectService;
import org.springframework.util.StringUtils;

@Service
public class SmsHomeRecommendSubjectServiceImpl extends ServiceImpl<SmsHomeRecommendSubjectMapper, SmsHomeRecommendSubject> implements SmsHomeRecommendSubjectService{
    @Override
    public int create(List<SmsHomeRecommendSubject> recommendSubjectList) {
        for (SmsHomeRecommendSubject recommendProduct : recommendSubjectList) {
            recommendProduct.setRecommendStatus(1);
            recommendProduct.setSort(0);
            baseMapper.insert(recommendProduct);
        }
        return recommendSubjectList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject recommendProduct = new SmsHomeRecommendSubject();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return baseMapper.updateById(recommendProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        return baseMapper.delete(Wrappers.<SmsHomeRecommendSubject>lambdaQuery()
                .in(SmsHomeRecommendSubject::getId, ids)
        );
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendSubject record = new SmsHomeRecommendSubject();
        record.setRecommendStatus(recommendStatus);
        return baseMapper.update(record, Wrappers.<SmsHomeRecommendSubject>lambdaQuery()
        .in(SmsHomeRecommendSubject::getId, ids)
        );
    }

    @Override
    public List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {

        Page<SmsHomeRecommendSubject> page = new Page<>(pageNum, pageSize);

        return baseMapper.selectPage(page,Wrappers.<SmsHomeRecommendSubject>lambdaQuery()
                .like(StringUtils.hasText(subjectName), SmsHomeRecommendSubject::getSubjectName, subjectName)
                .eq(recommendStatus != null, SmsHomeRecommendSubject::getRecommendStatus, recommendStatus)
        ).getRecords();
    }
}
