package org.echonanguo.lemall.portal.domain;

import org.echonanguo.lemall.mbg.model.OmsOrder;
import org.echonanguo.lemall.mbg.model.OmsOrderItem;

import java.util.List;

/**
 * 包含订单商品信息的订单详情
 * Created by echonanguo on 2025/1/22.
 */
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
