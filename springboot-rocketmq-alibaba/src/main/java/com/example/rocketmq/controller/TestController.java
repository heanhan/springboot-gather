package com.example.rocketmq.controller;

import com.example.rocketmq.utils.MQUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author :zhaojh0912
 * @Version : 1.0
 * @Description :Too
 **/

@RestController
public class TestController {

    @Resource
    private MQUtil mqUtil;

    @PostMapping(value = "/send")
    public String send(){
        String msg="生产消息";
        mqUtil.sendMessage(msg);
        return "success";
    }

}
