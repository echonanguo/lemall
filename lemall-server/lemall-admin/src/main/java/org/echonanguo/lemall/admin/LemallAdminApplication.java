package org.echonanguo.lemall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @Description: 后台管理微服务启动类
 * @Author:  echonanguo
 * @date:  2025/5/31 下午11:06
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LemallAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(LemallAdminApplication.class, args);
    }
}
