package org.echonanguo.lemall.auth.service;

import org.echonanguo.lemall.auth.domain.UmsAdminLoginParam;
import org.echonanguo.lemall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: 后台管理用户远程调用
 */
@FeignClient("lemall-admin")
public interface UmsAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam);
}
