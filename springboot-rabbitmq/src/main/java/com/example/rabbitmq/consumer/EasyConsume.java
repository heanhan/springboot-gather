package com.example.rabbitmq.consumer;

import com.example.rabbitmq.pojo.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 11:16 上午
 * @Version : 1.0
 * @Description :消费者
 **/

@Component
@Slf4j
public class EasyConsume {

    @RabbitListener(queues = "rabbit_easy_queue_1")
    @RabbitHandler
    public void process(Vehicle vehicle) {
        log.info("简单消费者接收到车车消息: " + vehicle);
    }
}
