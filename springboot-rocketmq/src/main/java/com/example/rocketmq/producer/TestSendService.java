package com.example.rocketmq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/8 1:58 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Component
public class TestSendService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    //生产消息
    public void send() {
        rocketMQTemplate.send("test-topic-1",
                MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
    }
}
