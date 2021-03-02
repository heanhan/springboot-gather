package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 11:05 上午
 * @Version : 1.0
 * @Description :配置一个简单的队列
 * 注意 Queue 在 org.springframework.amqp.core 包下即可
 **/

@Configuration
public class EasyRabbitConfig {

    /**
     * 创建一个bean实例
     * @return
     */
    @Bean
    public Queue easyQueue(){
        return new Queue("rabbit_easy_queue_1",true,false,true);
    }
}
