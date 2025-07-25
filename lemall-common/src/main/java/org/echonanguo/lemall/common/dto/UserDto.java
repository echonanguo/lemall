package org.echonanguo.lemall.common.dto;

import lombok.*;

import java.util.List;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: 权限框架中使用的日志封装类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String clientId;
    private List<String> permissionList;
}
