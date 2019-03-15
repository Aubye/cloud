package com.app.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CustomerBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerBootApplication.class, args);
    }
}
