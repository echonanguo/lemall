package org.echonanguo.lemall.portal.domain;

import lombok.Getter;
import lombok.Setter;
import org.echonanguo.lemall.model.CmsSubject;
import org.echonanguo.lemall.model.PmsBrand;
import org.echonanguo.lemall.model.PmsProduct;
import org.echonanguo.lemall.model.SmsHomeAdvertise;

import java.util.List;

/**
 * 首页内容返回信息封装
 * Created by echonanguo on 2025/1/28.
 */
@Getter
@Setter
public class HomeContentResult {
    //轮播广告
    private List<SmsHomeAdvertise> advertiseList;
    //推荐品牌
    private List<PmsBrand> brandList;
    //当前秒杀场次
    private HomeFlashPromotion homeFlashPromotion;
    //新品推荐
    private List<PmsProduct> newProductList;
    //人气推荐
    private List<PmsProduct> hotProductList;
    //推荐专题
    private List<CmsSubject> subjectList;
}
