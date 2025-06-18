package com.example.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // 启用 Feign 客户端
public class AuthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthClientApplication.class, args);
    }

}
