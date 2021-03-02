package com.example.rabbitmq.consumer;

import com.example.rabbitmq.pojo.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 7:01 下午
 * @Version : 1.0
 * @Description : 发布订阅消费者   一个队列 绑定两个消费者
 **/

@Slf4j
@Component
public class FantoutExchangeConsumer {

    /**
     * 一个队列绑定两个消费者
     * @param vehicle
     */
    @RabbitListener(queues = "rabbit_fanout_queue_one")
    public void consumerOne(Vehicle vehicle) {
        log.info("rabbit_fanout_queue_one队列 消费者1：收到消息---" + vehicle);
    }
    @RabbitListener(queues = "rabbit_fanout_queue_one")
    public void consumerOne2(Vehicle vehicle) {
        log.info("rabbit_fanout_queue_one队列 消费者2：收到消息---" + vehicle);
    }


    /**
     * 一个队列绑定两个消费者
     * @param vehicle
     */
    @RabbitListener(queues = "rabbit_fanout_queue_two")
    public void consumerTwo(Vehicle vehicle) {
        log.info("rabbit_fanout_queue_two队列 消费者1：收到消息---" + vehicle);
    }
    @RabbitListener(queues = "rabbit_fanout_queue_two")
    public void consumerTwo2(Vehicle vehicle) {
        log.info("rabbit_fanout_queue_two队列 消费者2：收到消息---" + vehicle);
    }
}
