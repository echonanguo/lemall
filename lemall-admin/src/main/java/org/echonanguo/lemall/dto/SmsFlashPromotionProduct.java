package org.echonanguo.lemall.dto;

import org.echonanguo.lemall.model.PmsProduct;
import org.echonanguo.lemall.model.SmsFlashPromotionProductRelation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 * Created by echonanguo on 2018/11/16.
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation{
    @Getter
    @Setter
    @Schema(title = "关联商品")
    private PmsProduct product;
}
