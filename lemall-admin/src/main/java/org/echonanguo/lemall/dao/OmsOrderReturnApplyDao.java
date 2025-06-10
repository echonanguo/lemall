package org.echonanguo.lemall.dao;

import org.echonanguo.lemall.dto.OmsOrderReturnApplyResult;
import org.echonanguo.lemall.dto.OmsReturnApplyQueryParam;
import org.echonanguo.lemall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 * Created by echonanguo on 2025/10/18.
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
