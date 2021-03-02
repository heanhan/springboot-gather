package com.example.rabbitmq.provider;

import com.example.rabbitmq.pojo.Vehicle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 7:00 下午
 * @Version : 1.0
 * @Description : 订阅模式的消息生产者
 **/

@Service
public class FanoutExchangeProvider {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFanoutExchangeMessage() {
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertSendAndReceive("fanout_exchange","",new Vehicle(i,i+"发布订阅车车"));
        }
    }
}
