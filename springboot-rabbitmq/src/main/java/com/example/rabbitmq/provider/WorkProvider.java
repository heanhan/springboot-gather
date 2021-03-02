package com.example.rabbitmq.provider;

import com.example.rabbitmq.pojo.Vehicle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 1:56 下午
 * @Version : 1.0
 * @Description :work模式生产者
 **/

@Service
public class WorkProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendWorkMessage() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("rabbit_work_queue",new Vehicle(i,i+"work车车"));
        }
    }
}
