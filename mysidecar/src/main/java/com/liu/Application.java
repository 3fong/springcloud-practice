package com.liu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @author liulei
 * @Description 启动类
 * @create 2017/10/27 11:20
 */
@SpringBootApplication
@EnableSidecar
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
