package com.example.quartz.controller;

import com.example.quartz.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 11:14 上午
 * @Version : 1.0
 * @Description :Too
 **/
@RequestMapping(value = "/job")
@RestController
public class JobController {

    @Autowired
    private JobService jobServiceImpl;

    @PostMapping(value = "/getCronById")
    public String getCronById(){
        String cronById = jobServiceImpl.getCronById();
        return "success";
    }
}
