package org.example.authservice.controller;


import org.example.authservice.auth.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

// 执行的是登录的审查
@RestController
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // 用户登录接口，验证用户名和密码，返回JWT token，写死的密码和账户
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // 假设用户名是"admin"密码是"password"（可以替换为实际的认证逻辑）
        System.out.println(1);
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());
        if ("admin".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            // 生成 token
            return jwtTokenProvider.generateToken(loginRequest.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
    @GetMapping("/auth")
    public boolean auth(@RequestHeader("Authorization") String authorization) {
        // 判断Authorization头部是否存在并且是Bearer token
        if (authorization != null) {
            return jwtTokenProvider.validateToken(authorization);  // 调用方法验证token
        }
        return false;  // 如果Authorization头部不存在或格式不对，返回false
    }
}
