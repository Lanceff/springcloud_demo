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
public class Application8003 {

    public static void main(String[] args) {
        SpringApplication.run(Application8003.class, args);
    }

}