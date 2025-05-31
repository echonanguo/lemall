package org.echonanguo.lemall.service.impl;

import org.echonanguo.lemall.mapper.OmsCompanyAddressMapper;
import org.echonanguo.lemall.model.OmsCompanyAddress;
import org.echonanguo.lemall.model.OmsCompanyAddressExample;
import org.echonanguo.lemall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by echonanguo on 2018/10/18.
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
