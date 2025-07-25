package org.echonanguo.lemall.portal.service;

import org.echonanguo.lemall.mbg.model.OmsCartItem;
import org.echonanguo.lemall.portal.domain.CartPromotionItem;

import java.util.List;

/**
 * Created by echonanguo on 2025/4/21.
 * 促销管理Service
 */
public interface OmsPromotionService {
    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
