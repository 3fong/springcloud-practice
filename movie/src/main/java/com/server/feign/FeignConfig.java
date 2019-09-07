package com.server.feign;

import feign.Feign;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author liulei
 * @Description 远程调用配置
 * @create 2017/10/23 20:17
 */
@Configuration
public class FeignConfig {
    public static final int FIVE_SECONDS = 5000;

    @Bean
    public Request.Options options() {
        return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
    }

    /**
     * @Title: feignBuilder
     * @Description: 局部禁用hystrix
     * @param: null
     */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
