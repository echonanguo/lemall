package org.echonanguo.lemall.portal.domain;

import org.echonanguo.lemall.mbg.model.SmsCoupon;
import org.echonanguo.lemall.mbg.model.SmsCouponHistory;
import org.echonanguo.lemall.mbg.model.SmsCouponProductCategoryRelation;
import org.echonanguo.lemall.mbg.model.SmsCouponProductRelation;

import java.util.List;

/**
 * 优惠券领取历史详情封装
 * Created by echonanguo on 2025/4/21.
 */
public class SmsCouponHistoryDetail extends SmsCouponHistory {
    //相关优惠券信息
    private SmsCoupon coupon;
    //优惠券关联商品
    private List<SmsCouponProductRelation> productRelationList;
    //优惠券关联商品分类
    private List<SmsCouponProductCategoryRelation> categoryRelationList;

    public SmsCoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(SmsCoupon coupon) {
        this.coupon = coupon;
    }

    public List<SmsCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<SmsCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<SmsCouponProductCategoryRelation> getCategoryRelationList() {
        return categoryRelationList;
    }

    public void setCategoryRelationList(List<SmsCouponProductCategoryRelation> categoryRelationList) {
        this.categoryRelationList = categoryRelationList;
    }
}
