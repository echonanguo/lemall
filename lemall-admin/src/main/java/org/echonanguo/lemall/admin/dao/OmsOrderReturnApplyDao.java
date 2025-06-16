package org.echonanguo.lemall.admin.dao;

import org.echonanguo.lemall.admin.dto.OmsReturnApplyQueryParam;
import org.echonanguo.lemall.admin.dto.OmsOrderReturnApplyResult;
import org.echonanguo.lemall.mbg.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 * Created by echonanguo on 2025/4/26.
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
