package org.echonanguo.lemall.portal.service.impl;

import org.echonanguo.lemall.mbg.mapper.OmsOrderReturnApplyMapper;
import org.echonanguo.lemall.mbg.model.OmsOrderReturnApply;
import org.echonanguo.lemall.portal.domain.OmsOrderReturnApplyParam;
import org.echonanguo.lemall.portal.service.OmsPortalOrderReturnApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 订单退货管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class OmsPortalOrderReturnApplyServiceImpl implements OmsPortalOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;
    @Override
    public int create(OmsOrderReturnApplyParam returnApply) {
        OmsOrderReturnApply realApply = new OmsOrderReturnApply();
        BeanUtils.copyProperties(returnApply,realApply);
        realApply.setCreateTime(new Date());
        realApply.setStatus(0);
        return returnApplyMapper.insert(realApply);
    }
}
