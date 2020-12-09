package com.example.sharding.controller;

import com.example.sharding.pojo.User;
import com.example.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/9 3:07 下午
 * @Version : 1.0
 * @Description :Too
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "save")
    public boolean save(User user) {
        return userService.save(user);
    }

    @GetMapping(value = "list")
    public List<User> findList() {
        return userService.findList();
    }
}
