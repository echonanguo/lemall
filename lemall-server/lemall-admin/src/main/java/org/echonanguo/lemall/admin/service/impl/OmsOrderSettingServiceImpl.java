package org.echonanguo.lemall.admin.service.impl;

import org.echonanguo.lemall.mbg.mapper.OmsOrderSettingMapper;
import org.echonanguo.lemall.mbg.model.OmsOrderSetting;
import org.echonanguo.lemall.admin.service.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单设置管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;

    @Override
    public OmsOrderSetting getItem(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, OmsOrderSetting orderSetting) {
        orderSetting.setId(id);
        return orderSettingMapper.updateByPrimaryKey(orderSetting);
    }
}
