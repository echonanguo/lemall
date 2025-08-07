package org.nanguo.lemall.business.admin.system.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.system.dto.request.UserAdminLoginRequestDTO;
import org.nanguo.lemall.business.admin.system.entity.UmsAdmin;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;
import org.nanguo.lemall.business.admin.system.service.UmsAdminService;
import org.nanguo.lemall.business.admin.system.service.UmsRoleService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/system")
@Tag(name = "后台用户管理",description = "AdminController")
public class UmsAdminController {

    private final UmsAdminService adminService;
    private final UmsRoleService roleService;

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
    @Operation(summary = "登出")
    @PostMapping("/logout")
    public Result<String> logout() {
        // 调用sa-token的退出登录方法，只需一行代码搞定
        StpUtil.logout();
        return Result.success("成功退出登录");
    }

    @Operation(summary = "获取当前登录用户信息")
    @GetMapping("/info")
    public Result<?> getAdminInfo() {
        UmsAdmin umsAdmin = adminService.getCurrentAdmin();
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return Result.success(data);
    }

}
