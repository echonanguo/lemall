package org.echonanguo.lemall.admin.controller;

import org.echonanguo.lemall.common.api.CommonResult;
import org.echonanguo.lemall.mbg.model.UmsMemberLevel;
import org.echonanguo.lemall.admin.service.UmsMemberLevelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 会员等级管理Controller
 * Created by echonanguo on 2025/4/26.
 */
@Controller
@Tag(name = "UmsMemberLevelController", description = "会员等级管理")
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService memberLevelService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Operation(summary = "查询所有会员等级")
    @ResponseBody
    public CommonResult<List<UmsMemberLevel>> list(@RequestParam("defaultStatus") Integer defaultStatus) {
        List<UmsMemberLevel> memberLevelList = memberLevelService.list(defaultStatus);
        return CommonResult.success(memberLevelList);
    }
}
