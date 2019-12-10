package com.hui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.hui.mapper")
@EnableEurekaClient
@EnableCircuitBreaker
public class ApplicationConfig8004 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig8004.class, args);
    }
}
