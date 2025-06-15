package com.example.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.stats.client")
public class StatsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatsClientApplication.class, args);
    }
}
