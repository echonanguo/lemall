package org.echonanguo.lemall.search.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * @Description: SpringDoc相关配置
 * @Author:  echonanguo
 * @date:  2025/6/1 上午12:34
 */
@Configuration
public class SpringDocConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI lemallSearchOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("lemall搜索系统")
                        .description("lemall搜索相关接口文档")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://github.com/echonanguo/lemall")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringBoot电商项目lemall全套文档")
                        .url("https://echonanguo.com"));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置访问`/swagger-ui/`路径时可以直接跳转到`/swagger-ui/index.html`
        registry.addViewController("/swagger-ui/").setViewName("redirect:/swagger-ui/index.html");
    }

}

