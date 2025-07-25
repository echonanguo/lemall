package org.echonanguo.lemall.admin.dao;

import org.echonanguo.lemall.admin.dto.OmsOrderQueryParam;
import org.echonanguo.lemall.admin.dto.OmsOrderDeliveryParam;
import org.echonanguo.lemall.admin.dto.OmsOrderDetail;
import org.echonanguo.lemall.mbg.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * Created by echonanguo on 2025/4/26.
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
