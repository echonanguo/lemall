package org.echonanguo.lemall.admin.dto;

import org.echonanguo.lemall.mbg.model.OmsOrder;
import org.echonanguo.lemall.mbg.model.OmsOrderItem;
import org.echonanguo.lemall.mbg.model.OmsOrderOperateHistory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by echonanguo on 2025/4/26.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    @Schema(title = "订单商品列表")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @Schema(title = "订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
