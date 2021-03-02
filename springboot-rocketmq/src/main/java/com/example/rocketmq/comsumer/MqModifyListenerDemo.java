package com.example.rocketmq.comsumer;

import com.example.rocketmq.constant.MqTopicConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * 消息队列消费端使用示例
 * @Date : 2020/12/8 2:09 下午
 * @Version : 1.0
 * @Description :RocketMQ 消息的监听
 * @author zhaojh0912*/

@Service
@RocketMQMessageListener(topic = MqTopicConstant.DEMO_TOPIC
        , consumerGroup = MqTopicConstant.DEMO_CONSUMER_GROUP_MODIFY
        , selectorExpression = MqTopicConstant.DEMO_TAG_MODIFY)
public class MqModifyListenerDemo implements RocketMQListener<String> {

    private static final Logger log = LoggerFactory.getLogger(MqRegisteredListenerDemo.class);
    @Override
    public void onMessage(String message) {
        log.info("received modify message: {}", message);
    }
}
