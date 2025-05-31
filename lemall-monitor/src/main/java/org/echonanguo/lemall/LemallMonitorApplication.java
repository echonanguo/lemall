package org.echonanguo.lemall;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @Author: echonanguo
 * @CreateTime: 2025-05-31
 * @Description: lemall监控微服务启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class LemallMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LemallMonitorApplication.class, args);
    }
}
