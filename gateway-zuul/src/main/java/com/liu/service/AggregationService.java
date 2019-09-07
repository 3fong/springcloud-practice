package com.liu.service;

import com.liu.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * @author liulei
 * @Description 聚合服务
 * @create 2017/10/28 11:18
 */
@Service
public class AggregationService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(String id) {
        return Observable.create(observer -> {
            restTemplate.getForObject("http://user/user/{id}", User.class, id);
        });
    }
}
