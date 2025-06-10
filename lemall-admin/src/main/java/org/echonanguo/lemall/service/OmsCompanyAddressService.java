package org.echonanguo.lemall.service;

import org.echonanguo.lemall.model.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管Service
 * Created by echonanguo on 2025/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
