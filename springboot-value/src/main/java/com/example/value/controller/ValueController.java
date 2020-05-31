package com.example.value.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/31 6:08 下午
 */
@RestController
@RequestMapping("/value")
@Slf4j
public class ValueController {

    /**
     * 读取配置文件的方式有如下几种
     * 1、直接使用@Value 的注解从配置文件中读取
     * 2、通过配置文件的方式读取 .properties或者 yml文件
     */
    @Value("${user-defined.name}")
    private String name;

    @GetMapping("/readValue")
    public String readValue(){
        //获取的name的值
        log.info("获取的配置文件中自定义的属性值为："+name);
        return name;
    }


}
