package com.example.rocketmq.rocketmq;

import lombok.Data;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/8 2:01 下午
 * @Version : 1.0
 * @Description :topic为消息的主题，content为消息的内容，具体内容可根据生产者和消费者之间进行协定。
 **/

@Data
public class MqMsg {


    /**
     * 一级消息：消息topic
     */
    private String topic;
    /**
     * 二级消息：消息topic对应的tags
     */
    private String tags;
    /**
     * 消息内容
     */
    private String content;
    // 省略getter/setter方法
}
