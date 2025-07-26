package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.admin.dto.OmsOrderReturnApplyResult;
import org.echonanguo.lemall.admin.dto.OmsReturnApplyQueryParam;
import org.echonanguo.lemall.admin.dto.OmsUpdateStatusParam;
import org.echonanguo.lemall.mbg.model.OmsOrderReturnApply;

import java.util.List;

/**
 * 退货申请管理Service
 * Created by echonanguo on 2025/4/26.
 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);
}
