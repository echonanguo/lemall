package org.echonanguo.lemall.admin.dto;

import org.echonanguo.lemall.mbg.model.SmsCoupon;
import org.echonanguo.lemall.mbg.model.SmsCouponProductCategoryRelation;
import org.echonanguo.lemall.mbg.model.SmsCouponProductRelation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 * Created by echonanguo on 2025/4/21.
 */
public class SmsCouponParam extends SmsCoupon {
    @Getter
    @Setter
    @Schema(title = "优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @Schema(title = "优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
