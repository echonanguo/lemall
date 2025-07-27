package org.nanguo.lemall.business.admin.system;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/system")
@Tag(name = "后台用户管理",description = "后台用户管理")
public class AdminController {

    @GetMapping("/test")
    @Operation(summary = "一个测试接口",description = "这是后台用户管理的测试接口")
    public String test() {
        return "test";
    }
}
