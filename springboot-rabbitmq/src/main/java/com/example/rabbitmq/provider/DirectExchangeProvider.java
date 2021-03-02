package com.example.rabbitmq.provider;

import com.example.rabbitmq.pojo.Vehicle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 7:33 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Service
public class DirectExchangeProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 三个参数 交换机 路由键 消息
     */
    public void sendDirectMessageOne() {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                rabbitTemplate.convertAndSend("direct_exchange",
                        "lei_routingKey_one",
                        new Vehicle(i, i + "路由键lei_routingKey_one车车"));
            } else {
                rabbitTemplate.convertAndSend("direct_exchange",
                        "lei_routingKey_two",
                        new Vehicle(i, i + "路由键lei_routingKey_two车车"));
            }

        }
    }
}
