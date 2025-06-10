package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {

    // 注入当前服务端口号
    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String getPort() {
        return "Response from port: " + port;
    }

    @GetMapping("/fallback")
    public String fallback() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            System.err.println("Error in fallback method: " + e.getMessage());
            Thread.currentThread().interrupt(); // 恢复中断状态
        }
        return "This is a fallback response from the PortController.";
    }
}
