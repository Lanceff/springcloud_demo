package com.hui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.hui.mapper")
@EnableEurekaClient
public class Application8001 {

    public static void main(String[] args) {
        SpringApplication.run(Application8001.class, args);
    }

}