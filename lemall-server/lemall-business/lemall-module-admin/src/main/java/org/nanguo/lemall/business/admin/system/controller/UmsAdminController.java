package org.nanguo.lemall.business.admin.system.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.system.dto.request.UserAdminLoginRequestDTO;
import org.nanguo.lemall.business.admin.system.service.UmsAdminService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/admin")
@Tag(name = "后台用户管理",description = "AdminController")
public class UmsAdminController {

    private final UmsAdminService adminService;
    @Value("${sa-token.token-prefix}")
    private String tokenHead;

    @Operation(summary = "登录",description = "后台管理登录后返回token")
    @PostMapping("/login")
    public Result<?> login(@Validated @RequestBody UserAdminLoginRequestDTO loginRequestDTO) {
        SaTokenInfo saTokenInfo  = adminService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        if (saTokenInfo == null) {
            return Result.fail("登录失败");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", saTokenInfo.getTokenValue() );
        tokenMap.put("tokenHead", tokenHead+" ");
        return Result.success(tokenMap);
    }

    // 退出登录接口
    @PostMapping("/logout")
    @Operation(summary = "登出")
    public Result<String> logout() {
        // 调用sa-token的退出登录方法，只需一行代码搞定
        StpUtil.logout();
        return Result.success("成功退出登录");
    }


}
