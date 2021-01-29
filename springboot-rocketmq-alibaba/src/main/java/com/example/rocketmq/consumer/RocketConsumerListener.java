package com.example.rocketmq.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * RocketMQ启动监听
 * @author zhaojianhua
 * @date 2021/01/10 16:07
 */
@Component
public class RocketConsumerListener implements CommandLineRunner {

    @Resource
    private RocketMQConsumer rocketMQConsumer;

    @Value("${rocketmq.mqSwitch}")
    private String mqSwitch;

    @Override
    public void run(String... args) {
           System.out.println("========aliCloud  rocketMQ消费者启动==========");
           rocketMQConsumer.normalSubscribe();
    }

}
