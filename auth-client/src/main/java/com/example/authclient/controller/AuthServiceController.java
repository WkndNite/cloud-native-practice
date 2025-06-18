package com.example.authclient.controller;

import lombok.RequiredArgsConstructor;
import com.example.authclient.client.AUTHServiceClient;
import com.example.authclient.model.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthServiceController {

    private final AUTHServiceClient authServiceClient;

    // 用户登录接口，接收用户名和密码并返回 JWT token
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // 调用 Feign 客户端的登录方法，获取 token
        return authServiceClient.login(loginRequest);
    }

    // 认证接口，验证传递的 JWT token
    @GetMapping("/auth")
    public boolean verifyToken(@RequestHeader("Authorization") String authorization) {
        // 调用 Feign 客户端的认证方法，验证 token
        return authServiceClient.auth(authorization);
    }
}
