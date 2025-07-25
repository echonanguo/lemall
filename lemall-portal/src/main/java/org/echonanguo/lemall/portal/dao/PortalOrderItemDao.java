package org.echonanguo.lemall.portal.dao;

import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.mbg.model.OmsOrderItem;

import java.util.List;

/**
 * 订单商品信息自定义Dao
 * Created by echonanguo on 2025/1/22.
 */
public interface PortalOrderItemDao {
    int insertList(@Param("list") List<OmsOrderItem> list);
}
