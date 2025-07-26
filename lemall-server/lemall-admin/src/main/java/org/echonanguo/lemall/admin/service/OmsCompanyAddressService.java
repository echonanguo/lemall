package org.echonanguo.lemall.admin.service;

import org.echonanguo.lemall.mbg.model.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管Service
 * Created by echonanguo on 2025/4/26.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
