package com.example.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ScoreClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoreClientApplication.class, args);
    }
} 