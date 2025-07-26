package org.echonanguo.lemall.admin.service.impl;

import org.echonanguo.lemall.mbg.mapper.OmsCompanyAddressMapper;
import org.echonanguo.lemall.mbg.model.OmsCompanyAddress;
import org.echonanguo.lemall.mbg.model.OmsCompanyAddressExample;
import org.echonanguo.lemall.admin.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by echonanguo on 2025/4/26.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
