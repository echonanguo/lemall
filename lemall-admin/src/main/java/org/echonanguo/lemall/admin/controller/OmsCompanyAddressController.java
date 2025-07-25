package org.echonanguo.lemall.admin.controller;

import org.echonanguo.lemall.common.api.CommonResult;
import org.echonanguo.lemall.mbg.model.OmsCompanyAddress;
import org.echonanguo.lemall.admin.service.OmsCompanyAddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
 * @Description: 收货地址管理Controller
 * @Author:  echonanguo
 * @date:  2025/5/31 下午11:13
 */
@Controller
@Tag(name = "OmsCompanyAddressController", description = "收货地址管理")
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService companyAddressService;

    @Operation(summary = "获取所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCompanyAddress>> list() {
        List<OmsCompanyAddress> companyAddressList = companyAddressService.list();
        return CommonResult.success(companyAddressList);
    }
}
