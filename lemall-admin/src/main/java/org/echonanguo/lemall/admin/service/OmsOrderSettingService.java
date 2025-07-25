package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.OmsOrderSetting;

/**
 * 订单设置Service
 * Created by echonanguo on 2025/4/26.
 */
public interface OmsOrderSettingService {
    /**
     * 获取指定订单设置
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     */
    int update(Long id, OmsOrderSetting orderSetting);
}
