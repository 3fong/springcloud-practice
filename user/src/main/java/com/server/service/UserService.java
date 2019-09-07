package com.server.service;

import org.springframework.stereotype.Service;

import com.server.bean.User;

/**
 * @author liulei
 * @Description 用户服务
 * @create 2017/10/10 17:04
 */
@Service
public class UserService {

    public User findById(String id) {
        System.out.println("8079运行....");
        return new User("liu", "刘磊");
    }
}
