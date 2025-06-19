package com.example.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication // 不指定 scanBasePackages，默认扫描本包及子包
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.authclient.client")
public class AuthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthClientApplication.class, args);
    }

}
