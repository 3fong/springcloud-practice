package com.euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerHaApplication.class, args);
    }
}
