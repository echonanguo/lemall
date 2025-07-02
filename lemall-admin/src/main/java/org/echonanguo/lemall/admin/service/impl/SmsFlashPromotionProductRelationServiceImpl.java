package org.echonanguo.lemall.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.echonanguo.lemall.admin.dto.SmsFlashPromotionProduct;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.echonanguo.lemall.common.model.SmsFlashPromotionProductRelation;
import org.echonanguo.lemall.admin.mapper.SmsFlashPromotionProductRelationMapper;
import org.echonanguo.lemall.admin.service.SmsFlashPromotionProductRelationService;
@Service
public class SmsFlashPromotionProductRelationServiceImpl extends ServiceImpl<SmsFlashPromotionProductRelationMapper, SmsFlashPromotionProductRelation> implements SmsFlashPromotionProductRelationService{
    @Override
    public int create(List<SmsFlashPromotionProductRelation> relationList) {
        for (SmsFlashPromotionProductRelation relation : relationList) {
            baseMapper.insert(relation);
        }
        return relationList.size();
    }

    @Override
    public int update(Long id, SmsFlashPromotionProductRelation relation) {
        relation.setId(id);
        return baseMapper.updateById(relation);
    }

    @Override
    public int delete(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public SmsFlashPromotionProductRelation getItem(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum) {
        return baseMapper.getList(new Page<>(pageNum,pageSize),flashPromotionId,flashPromotionSessionId).getRecords();
    }

    @Override
    public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        return baseMapper.selectCount(Wrappers.<SmsFlashPromotionProductRelation>lambdaQuery()
                .eq(SmsFlashPromotionProductRelation::getFlashPromotionId,flashPromotionId)
                .eq(SmsFlashPromotionProductRelation::getFlashPromotionSessionId,flashPromotionSessionId)
        );
    }
}
