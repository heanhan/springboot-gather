package com.example.rocketmq.constant;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/8 2:08 下午
 * @Version : 1.0
 * @Description :/**
 *  * 消息队列相关常亮配置，包括group、topic、tag
 *  *
 *  **/

public class MqTopicConstant {

    /**
     * 示例消息队列，topic1个
     */
    public static final String DEMO_TOPIC = "test-top-1";
    /**
     * 注册tag
     */
    public static final String DEMO_TAG_REGISTERED = "registered";
    /**
     * 修改tag
     */
    public static final String DEMO_TAG_MODIFY = "modify";
    /**
     * consumer group
     */
    public static final String DEMO_CONSUMER_GROUP_REGISTERED = "consumer_test-top-1_registered";
    public static final String DEMO_CONSUMER_GROUP_MODIFY = "consumer_test-top-1_modify";
}
