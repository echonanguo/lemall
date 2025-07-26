package org.echonanguo.lemall.auth.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: 用户登录参数
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminLoginParam {
    @NotEmpty
    @Schema(title = "用户名", required = true)
    private String username;
    @NotEmpty
    @Schema(title = "密码", required = true)
    private String password;
}
