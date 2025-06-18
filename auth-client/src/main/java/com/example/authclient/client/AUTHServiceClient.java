package com.example.authclient.client;

import com.example.authclient.model.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "auth-service")
public interface AUTHServiceClient {
    // 登录接口：发送用户名和密码，返回 JWT token
    @PostMapping("/login")
    String login(@RequestBody LoginRequest loginRequest);

    // 认证接口：验证 Authorization 头部中的 JWT token
    @GetMapping("/auth")
    boolean auth(@RequestHeader("Authorization") String authorization);
}