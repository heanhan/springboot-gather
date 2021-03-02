package com.example.rabbitmq.controller;

import com.example.rabbitmq.provider.WorkProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 1:51 下午
 * @Version : 1.0
 * @Description : 一个生产者 多个消费者
 **/

@RestController
@RequestMapping(value = "/rabbitmq")
public class WorkController {

    @Autowired
    private WorkProvider workProvider;

    @GetMapping(value = "/workQueue")
    private String workQueue(){
        workProvider.sendWorkMessage();
        return "success";
    }


}
