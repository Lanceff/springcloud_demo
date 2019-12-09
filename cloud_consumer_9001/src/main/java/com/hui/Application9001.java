package com.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.hui"})
//@RibbonClient(name = "myRule", configuration = MyRandomRule.class)
public class Application9001 {

    public static void main(String[] args) {
        SpringApplication.run(Application9001.class, args);
    }
}
