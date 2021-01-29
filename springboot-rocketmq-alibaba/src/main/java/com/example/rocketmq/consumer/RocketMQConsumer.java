package com.example.rocketmq.consumer;

import com.aliyun.openservices.ons.api.*;
import com.example.rocketmq.config.RocketMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Properties;

/**
 * RocketMQ 消费者
 * @author zhaojianhua
 * @date 2021/01/10 16:07
 */
@Component
@Slf4j
public class RocketMQConsumer {

    @Autowired
    private RocketMQConfig rocketMQConfig;


    /**
     * 订阅消息，处理业务
     */
    public void normalSubscribe() {
        Properties properties = rocketMQConfig.getProperties();
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(RocketMQConfig.TOPIC, "*", new MessageListener() {
            @Override
            public Action consume(Message message, ConsumeContext context) {
                try {
                    //接收到的消息内容
                    String msg = new String(message.getBody(), "UTF-8");
                    String tag = message.getTag();
                    log.info("收到消息messageID：" + message.getMsgID() + " msg:" + msg);
                    return Action.CommitMessage;
                } catch (Exception e) {
                    log.info("消费失败：messageID：" + message.getMsgID());
                    e.printStackTrace();
                    return Action.ReconsumeLater;
                }
            }
        });
        consumer.start();
    }
}
