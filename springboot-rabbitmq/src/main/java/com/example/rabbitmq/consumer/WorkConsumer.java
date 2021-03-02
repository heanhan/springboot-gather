package com.example.rabbitmq.consumer;

import com.example.rabbitmq.pojo.Vehicle;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 1:57 下午
 * @Version : 1.0
 * @Description :work 模式下的消费者
 **/

@Component
public class WorkConsumer {

    @RabbitListener(queues = "rabbit_work_queue")
    public void work1(Vehicle vehicle) {
        System.out.println("消费者1--work--接收到车车消息: " + vehicle);
    }
    @RabbitListener(queues = "rabbit_work_queue")
    public void work2(Vehicle vehicle) {
        System.out.println("消费者2--work--接收到车车消息: " + vehicle);
    }
}
