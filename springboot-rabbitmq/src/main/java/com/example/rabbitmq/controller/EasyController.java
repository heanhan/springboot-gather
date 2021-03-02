package com.example.rabbitmq.controller;

import com.example.rabbitmq.provider.EasyProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 11:17 上午
 * @Version : 1.0
 * @Description :演示功能 一个生产者，一个消费者
 **/

@RestController
@RequestMapping(value = "/rabbitmq")
public class EasyController {

    @Autowired
    public EasyProvider easyProvider;

    @GetMapping(value = "/easySend")
    public String easySend(){
        easyProvider.sendMessage();
        return "success";
    }
}
