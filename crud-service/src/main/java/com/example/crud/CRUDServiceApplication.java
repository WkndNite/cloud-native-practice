package com.example.crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 不指定 scanBasePackages，默认扫描本包及子包
@MapperScan("com.example.crud.mapper") // 指定 Mapper 包扫描路径
public class CRUDServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CRUDServiceApplication.class, args);
    }
}
