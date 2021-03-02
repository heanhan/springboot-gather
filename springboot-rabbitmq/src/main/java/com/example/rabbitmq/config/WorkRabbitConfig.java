package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 1:52 下午
 * @Version : 1.0
 * @Description :一个生产者 多个消费者
 **/

@Configuration
public class WorkRabbitConfig {

    /**
     * 创建一个bean实例
     *
     * @return
     */
    @Bean
    public Queue workQueue() {
        /**
         * Queue 中第一个参数是队列名称，第二个 是否持久化，第三个 是否独自  第四个参数 自动删除
         */
        return new Queue("rabbit_work_queue",true,false,true);
    }
}
