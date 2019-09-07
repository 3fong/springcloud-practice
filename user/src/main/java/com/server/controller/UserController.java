package com.server.controller;

import com.server.bean.User;
import com.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulei
 * @Description 用户控制层
 * @create 2017/10/11 9:22
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }
}
