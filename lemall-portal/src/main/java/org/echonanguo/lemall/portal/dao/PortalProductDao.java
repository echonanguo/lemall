package org.echonanguo.lemall.portal.dao;

import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.SmsCoupon;
import org.echonanguo.lemall.portal.domain.CartProduct;
import org.echonanguo.lemall.portal.domain.PromotionProduct;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 * Created by echonanguo on 2025/4/21.
 */
public interface PortalProductDao {
    CartProduct getCartProduct(@Param("id") Long id);
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId,@Param("productCategoryId")Long productCategoryId);
}
