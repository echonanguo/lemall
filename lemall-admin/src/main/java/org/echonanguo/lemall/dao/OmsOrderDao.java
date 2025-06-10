package org.echonanguo.lemall.dao;

import org.echonanguo.lemall.dto.OmsOrderDeliveryParam;
import org.echonanguo.lemall.dto.OmsOrderDetail;
import org.echonanguo.lemall.dto.OmsOrderQueryParam;
import org.echonanguo.lemall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * Created by echonanguo on 2025/10/12.
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
