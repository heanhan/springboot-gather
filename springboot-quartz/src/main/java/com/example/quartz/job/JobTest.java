package com.example.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 1:30 下午
 * @Version : 1.0
 * @Description :Too
 **/

public class JobTest {

    public static void main(String[] args) {
        //创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(JobDemo.class).build();
        //创建Trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?")).build();
        //创建Schedule
        try {
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            //开启定时任务
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
