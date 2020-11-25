package com.example.union.controller;

import com.example.union.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :zhaojh0912
 * @Date : 2020/11/25 3:16 下午
 * @Version : 1.0
 * @Description :Too
 **/

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/getUser")
    public User getUser(){
        User user=new User();
        user.setId(1000L);
        user.setAccount("zhaojianhua");
        user.setPassword("123456");
        user.setEmail("1763124707@qq.com");
        return user;
    }
}
