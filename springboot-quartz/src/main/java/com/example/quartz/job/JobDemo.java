package com.example.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 1:23 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Slf4j
@Component
public class JobDemo implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("定时任务jobdemo开始执行");
        log.info("定时任务jobdemo执行结束");
    }
}
