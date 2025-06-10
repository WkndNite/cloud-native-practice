package com.example.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.client.CRUDServiceClient;

import lombok.RequiredArgsConstructor;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/client/port")
@RequiredArgsConstructor
public class PortServiceController {

    private final CRUDServiceClient portServiceClient;

    @GetMapping
    @CircuitBreaker(name = "getPortCB", fallbackMethod = "getPortFallback")
    public String getPort() {
        return portServiceClient.getPort();
    }

    @GetMapping("/fallback")
    @CircuitBreaker(name = "fallbackCB", fallbackMethod = "fallbackFallback")
    public String fallback() {
        return portServiceClient.fallback();
    }

    // fallback 方法签名需匹配原方法（参数 + 返回值）
    public String getPortFallback(Throwable t) {
        return "Fallback from getPort(): " + t.getMessage();
    }

    public String fallbackFallback(Throwable t) {
        return "Fallback from fallback(): " + t.getMessage();
    }
}
