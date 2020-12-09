package com.example.rocketmq.rocketmq;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/8 2:01 下午
 * @Version : 1.0
 * @Description :Too
 **/

public interface RocketMqService {

    /**
     * 同步发送消息<br/>
     * <p>
     * 当发送的消息很重要是，且对响应时间不敏感的时候采用sync方式;
     *
     * @param mqMsg 发送消息实体类
     */
    void send(MqMsg mqMsg);


    /**
     * 异步发送消息，异步返回消息结果<br/>
     * <p>
     * 当发送的消息很重要，且对响应时间非常敏感的时候采用async方式；
     *
     * @param mqMsg 发送消息实体类
     */
    void asyncSend(MqMsg mqMsg);


    /**
     * 直接发送发送消息，不关心返回结果，容易消息丢失，适合日志收集、不精确统计等消息发送;<br/>
     * <p>
     * 当发送的消息不重要时，采用one-way方式，以提高吞吐量；
     *
     * @param mqMsg 发送消息实体类
     */
    void syncSendOrderly(MqMsg mqMsg);
}
