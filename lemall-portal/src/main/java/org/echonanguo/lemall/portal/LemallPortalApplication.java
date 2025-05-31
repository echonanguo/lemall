package org.echonanguo.lemall.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "org.echonanguo.lemall")
public class LemallPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LemallPortalApplication.class, args);
    }

}
