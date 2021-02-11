package com.example.scheduled.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/10 10:43 上午
 * @Version : 1.0
 * @Description :定时任务  使用cron 表达式
 **/

@Slf4j
@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0/2 8-20 * * ?")
    public void taskOne(){
      log.info("定时任务Cron 表达式任务执行..."+ LocalDateTime.now());

    }
}
