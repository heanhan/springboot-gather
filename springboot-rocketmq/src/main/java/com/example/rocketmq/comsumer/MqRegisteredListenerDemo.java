package com.example.rocketmq.comsumer;

import com.example.rocketmq.constant.MqTopicConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/8 2:06 下午
 * @Version : 1.0
 * @Description :Too
 **/
@Service
@RocketMQMessageListener(topic = MqTopicConstant.DEMO_TOPIC
        , consumerGroup = MqTopicConstant.DEMO_CONSUMER_GROUP_REGISTERED
        , selectorExpression = MqTopicConstant.DEMO_TAG_REGISTERED)
public class MqRegisteredListenerDemo implements RocketMQListener<String> {

    private static final Logger log = LoggerFactory.getLogger(MqRegisteredListenerDemo.class);
    @Override
    public void onMessage(String message) {
        log.info("received registered message: {}", message);
    }
}
