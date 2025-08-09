package org.nanguo.lemall.business.admin.system.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Schema(name = "用户响应dto")
public class UmsAdminResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "账号名")
    private String username;

    @Schema(description = "名字")
    private String nickName;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "添加时间")
    private Date createTime;

    @Schema(description = "登录时间")
    private Date loginTime;

    @Schema(description = "状态")
    private Integer status;
}
