package com.example.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter {

    /**
     * 网关认证过滤器，用于校验请求中的token参数
     *
     * 从请求查询参数中获取token，若token不等于"1"则返回401未授权状态，
     * 否则继续执行后续过滤器链
     * 注意如果不带token返回的是500
     *
     * @param exchange 服务器网络交换对象，包含请求和响应信息
     * @param chain    网关过滤器链
     * @return Mono<Void> 异步处理结果
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        System.out.println(token);
        if (!token.equals("1")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}