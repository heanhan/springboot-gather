package com.example.rabbitmq.controller;

import com.example.rabbitmq.provider.FanoutExchangeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 7:05 下午
 * @Version : 1.0
 * @Description :Too
 **/

@RestController
@RequestMapping(value = "/rabbitmq")
public class FanoutController {

    @Autowired
    private FanoutExchangeProvider fanoutExchangeProvider;

    @GetMapping(value = "/sendFanoutExchangeMessage")
    public String sendFanoutExchangeMessage(){
        fanoutExchangeProvider.sendFanoutExchangeMessage();
        return "success";
    }
}
