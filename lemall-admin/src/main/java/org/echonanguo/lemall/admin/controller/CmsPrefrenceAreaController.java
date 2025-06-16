package org.echonanguo.lemall.admin.controller;

import org.echonanguo.lemall.admin.service.CmsPrefrenceAreaService;
import org.echonanguo.lemall.common.api.CommonResult;
import org.echonanguo.lemall.mbg.model.CmsPrefrenceArea;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
 * @Description: 商品优选管理Controller
 * @Author:  echonanguo
 * @date:  2025/5/31 下午11:12
 */
@Controller
@Tag(name = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;

    @Operation(summary = "获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsPrefrenceArea>> listAll() {
        List<CmsPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        return CommonResult.success(prefrenceAreaList);
    }
}
