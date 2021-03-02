package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 7:30 下午
 * @Version : 1.0
 * @Description : Direct 模式
 * 直连路由键交换机模式，其会直连指定一个路由键与队列 与交换机进行绑定
 * 路由模式 在发布订阅基础上 添加路由键 吧消息交给符合指定路由键的队列
 * 这里定义两个队列绑到一个交换机上 对应两个不同的路由键
 *
 **/

@Configuration
public class DirectExchangeConfig {

    /**
     * 队列一
     * @return
     */
    @Bean
    public Queue directQueueOne() {
        return new Queue("rabbit_direct_queue_one");
    }

    /**
     * 队列二
     * @return
     */
    @Bean
    public Queue directQueueTwo() {
        return new Queue("rabbit_direct_queue_two");
    }

    /**
     * 定义交换机 direct类型
     * @return
     */
    @Bean
    public DirectExchange myDirectExchange() {
        return new DirectExchange("direct_exchange");
    }

    /**
     * 队列 绑定到交换机 再指定一个路由键
     * directQueueOne() 会找到上方定义的队列bean
     * @return
     */
    @Bean
    public Binding DirectExchangeOne() {
        return BindingBuilder.bind(directQueueOne()).to(myDirectExchange()).with("lei_routingKey_one");
    }
    /**
     * 队列 绑定到交换机 再指定一个路由键
     * @return
     */
    @Bean
    public Binding DirectExchangeTwo() {
        return BindingBuilder.bind(directQueueTwo()).to(myDirectExchange()).with("lei_routingKey_two");
    }

}
