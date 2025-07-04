package org.echonanguo.lemall.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;

/**
 * 修改用户名密码参数
 * Created by echonanguo on 2025/4/26.
 */
@Getter
@Setter
public class UpdateAdminPasswordParam {
    @NotEmpty
    @Schema(title = "用户名", required = true)
    private String username;
    @NotEmpty
    @Schema(title = "旧密码", required = true)
    private String oldPassword;
    @NotEmpty
    @Schema(title = "新密码", required = true)
    private String newPassword;
}
