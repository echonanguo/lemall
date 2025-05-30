package org.echonanguo.lemall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LemallSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LemallSearchApplication.class, args);
    }
}
