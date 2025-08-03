package org.nanguo.lemall.business.admin.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该业务模块的doc配置类
 */
@Configuration
public class SpringDocAdminConfig {

    @Bean
    public GroupedOpenApi adminGroupApi() {
        return GroupedOpenApi.builder()
                .group("后台管理")
                .pathsToMatch("/lemall-admin/**")
                .build();
    }
}
