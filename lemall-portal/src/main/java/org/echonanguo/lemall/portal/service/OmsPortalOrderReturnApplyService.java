package org.echonanguo.lemall.portal.service;

import org.echonanguo.lemall.portal.domain.OmsOrderReturnApplyParam;

/**
 * 订单退货管理Service
 * Created by echonanguo on 2025/4/26.
 */
public interface OmsPortalOrderReturnApplyService {
    /**
     * 提交申请
     */
    int create(OmsOrderReturnApplyParam returnApply);
}
