package org.echonanguo.lemall.portal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 生成订单时传入的参数
 * Created by echonanguo on 2025/1/22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderParam {
    @Schema(title = "收货地址ID")
    private Long memberReceiveAddressId;
    @Schema(title = "优惠券ID")
    private Long couponId;
    @Schema(title = "使用的积分数")
    private Integer useIntegration;
    @Schema(title = "支付方式")
    private Integer payType;
    @Schema(title = "被选中的购物车商品ID")
    private List<Long> cartIds;
}
