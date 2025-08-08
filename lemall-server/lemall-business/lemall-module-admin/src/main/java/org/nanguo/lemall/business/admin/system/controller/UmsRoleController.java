package org.nanguo.lemall.business.admin.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.nanguo.lemall.business.admin.system.entity.UmsRole;
import org.nanguo.lemall.business.admin.system.service.UmsRoleService;
import org.nanguo.lemall.util.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lemall-admin/system/role")
@Tag(name = "后台角色管理",description = "UmsRoleController")
public class UmsRoleController {

    private final UmsRoleService umsRoleService;

    @Operation(summary = "获取所有角色")
    @GetMapping("/listAll")
    public Result<List<UmsRole>> listAll() {
        List<UmsRole> roleList = umsRoleService.list();
        return Result.success(roleList);
    }
}
