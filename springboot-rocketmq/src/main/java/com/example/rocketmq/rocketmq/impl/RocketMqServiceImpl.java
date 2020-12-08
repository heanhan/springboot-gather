package com.example.rocketmq.rocketmq.impl;

import com.example.rocketmq.rocketmq.MqMsg;
import com.example.rocketmq.rocketmq.RocketMqService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/8 2:03 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Service("rocketMqService")
public class RocketMqServiceImpl implements RocketMqService {

    private static final Logger log = LoggerFactory.getLogger(RocketMqServiceImpl.class);
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送消息<br/>
     * <p>
     * 当发送的消息很重要是，且对响应时间不敏感的时候采用sync方式;
     *
     * @param mqMsg 发送消息实体类
     */
    @Override
    public void send(MqMsg mqMsg) {
        log.info("send发送消息到mqMsg={}", mqMsg);
        rocketMQTemplate.send(mqMsg.getTopic() + ":" + mqMsg.getTags(),
                MessageBuilder.withPayload(mqMsg.getContent()).build());
    }

    /**
     * 异步发送消息，异步返回消息结果<br/>
     * <p>
     * 当发送的消息很重要，且对响应时间非常敏感的时候采用async方式；
     *
     * @param mqMsg 发送消息实体类
     */
    @Override
    public void asyncSend(MqMsg mqMsg) {
        log.info("asyncSend发送消息到mqMsg={}", mqMsg);
        rocketMQTemplate.asyncSend(mqMsg.getTopic() + ":" + mqMsg.getTags(), mqMsg.getContent(),
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        // 成功不做日志记录或处理
                    }
                    @Override
                    public void onException(Throwable throwable) {
                        log.info("mqMsg={}消息发送失败", mqMsg);
                    }
                });
    }

    /**
     * 直接发送发送消息，不关心返回结果，容易消息丢失，适合日志收集、不精确统计等消息发送;<br/>
     * <p>
     * 当发送的消息不重要时，采用one-way方式，以提高吞吐量；
     *
     * @param mqMsg 发送消息实体类
     */
    @Override
    public void syncSendOrderly(MqMsg mqMsg) {
        log.info("syncSendOrderly发送消息到mqMsg={}", mqMsg);
        rocketMQTemplate.sendOneWay(mqMsg.getTopic() + ":" + mqMsg.getTags(), mqMsg.getContent());
    }
}
