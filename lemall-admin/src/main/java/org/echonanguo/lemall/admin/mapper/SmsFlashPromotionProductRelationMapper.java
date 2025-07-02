package org.echonanguo.lemall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.admin.dto.SmsFlashPromotionProduct;
import org.echonanguo.lemall.common.model.SmsFlashPromotionProductRelation;

import java.util.List;

public interface SmsFlashPromotionProductRelationMapper extends BaseMapper<SmsFlashPromotionProductRelation> {
    /**
     * 获取限时购及相关商品信息
     */
    IPage<SmsFlashPromotionProduct> getList(IPage<SmsFlashPromotionProduct> page, @Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
