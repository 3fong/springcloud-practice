package com.server.controller;

import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.server.bean.User;
import com.server.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;

/**
 * @author liulei
 * @Description 电影
 * @create 2017/9/4 16:57
 */
@RestController
public class MovieController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users")
    public List<ServiceInstance> getUsers() {
        return this.discoveryClient.getInstances("user");
    }

    @HystrixCommand(fallbackMethod = "fingByIdFallBack", commandProperties = {@HystrixProperty(name =
            "circuitBreaker.requestVolumeThreshold", value = "2")})
    @GetMapping("/user")
    public User getUserById(String id) {
        User user = userFeignClient.findById(id);
        System.out.println(user);
        return user;
    }

    /**
     * @Title: fingByIdFallBack
     * @Description: 回退方法, 请求失败, 超时, 被拒绝及断路器打开都会进行回退
     * @param: null
     */
    public User fingByIdFallBack(String id) {
        System.out.println("触发回退...");
        return new User("lei", "hystrix");
    }
}
