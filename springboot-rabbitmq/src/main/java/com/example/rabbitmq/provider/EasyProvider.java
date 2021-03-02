package com.example.rabbitmq.provider;

import com.example.rabbitmq.pojo.Vehicle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 11:09 上午
 * @Version : 1.0
 * @Description :生产者
 **/

@Service
public class EasyProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(){
        for (int i = 0; i < 10; i++) {
            /**
             *convertAndSend  是无序发送
             * convertSendAndReceive 是有序发送
             */
            rabbitTemplate.convertAndSend("rabbit_easy_queue_1",new Vehicle(i,i+"车车"));
//            rabbitTemplate.convertSendAndReceive("rabbit_easy_queue",new Vehicle(i,i+"车车"));
        }
    }


}
