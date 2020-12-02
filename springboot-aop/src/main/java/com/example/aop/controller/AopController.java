package com.example.aop.controller;

import com.example.aop.anotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/6/7 10:12 下午
 */

@RequestMapping(value = "/aop")
@RestController
public class AopController {

    @Log(key = "1",name = "getLog",description = "获取日志测试")
    @GetMapping(value = "/getLog")
    public String getLog(){
        return "ok!";
    }
}
