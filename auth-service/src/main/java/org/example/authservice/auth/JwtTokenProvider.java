package org.example.authservice.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component // Add this annotation to make JwtTokenProvider a Spring Bean
public class JwtTokenProvider {

    // Generate a secure key for HS512
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512); // 512-bit key for HS512

    // 生成 JWT Token
    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 3600000))  // 设置过期时间为1小时
                .signWith(secretKey)  // Use the securely generated key
                .compact();
    }

    // 校验 token 是否有效
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 从 token 中提取用户名
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}
