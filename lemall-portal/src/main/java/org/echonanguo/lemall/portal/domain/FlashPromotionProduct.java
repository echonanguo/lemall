package org.echonanguo.lemall.portal.domain;

import lombok.Getter;
import lombok.Setter;
import org.echonanguo.lemall.mbg.model.PmsProduct;

import java.math.BigDecimal;

/**
 * 秒杀信息和商品对象封装
 * Created by echonanguo on 2025/4/26.
 */
@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct{
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}
