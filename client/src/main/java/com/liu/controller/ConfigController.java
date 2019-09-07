package com.liu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @Description 获取服务端配置
 * @create 2017/10/29 15:06
 */
@RefreshScope
@RestController
public class ConfigController {
    // 绑定服务端配置文件中参数
    @Value("${profile}")
    private String profile;
    // 注入失败,不知道为什么
    //    @Autowired
    //    private Environment environment;

    @GetMapping("/pro")
    public String hello() {
        return this.profile;
    }
}
