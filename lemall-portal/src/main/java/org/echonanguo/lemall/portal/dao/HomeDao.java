package org.echonanguo.lemall.portal.dao;

import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.CmsSubject;
import org.echonanguo.lemall.mbg.model.PmsBrand;
import org.echonanguo.lemall.mbg.model.PmsProduct;
import org.echonanguo.lemall.portal.domain.FlashPromotionProduct;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 * Created by echonanguo on 2025/4/26.
 */
public interface HomeDao {

    /**
     * 获取推荐品牌
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);
    /**
     * 获取人气推荐
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
