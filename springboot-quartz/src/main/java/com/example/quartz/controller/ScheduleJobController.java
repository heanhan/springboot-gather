package com.example.quartz.controller;

import com.example.quartz.entity.ScheduleJobEntity;
import com.example.quartz.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 2:51 下午
 * @Version : 1.0
 * @Description :Too
 **/

@RestController
@RequestMapping("/schedule")
public class ScheduleJobController {

    @Autowired
    private ScheduleJobService scheduleJobService;


    @PostMapping("/add")
    public String add(@RequestBody ScheduleJobEntity scheduleJobEntity) {
        scheduleJobService.add(scheduleJobEntity);
        return "job is success!";
    }
}
