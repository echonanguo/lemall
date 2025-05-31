package org.echonanguo.lemall.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: Lemall微服务启动类
 */
@SpringBootApplication
@EnableFeignClients
public class LemallAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LemallAuthApplication.class, args);
    }
}
