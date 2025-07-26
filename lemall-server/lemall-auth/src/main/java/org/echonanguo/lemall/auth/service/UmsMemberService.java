package org.echonanguo.lemall.auth.service;

import org.echonanguo.lemall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: 前台会员远程调用
 */
@FeignClient("lemall-portal")
public interface UmsMemberService {
    @PostMapping("/sso/login")
    CommonResult login(@RequestParam("username") String username, @RequestParam("password") String password);
}
