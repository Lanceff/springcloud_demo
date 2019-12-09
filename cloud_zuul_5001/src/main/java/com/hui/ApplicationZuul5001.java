package com.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ApplicationZuul5001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationZuul5001.class, args);
    }
}
