package com.example.rocketmq.utils;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendResult;
import com.example.rocketmq.config.RocketMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @Author :zhaojh0912
 * @Date : 2021/1/29 2:06 下午
 * @Version : 1.0
 * @Description :RocketMQ的工具类
 **/

@Slf4j
@Configuration
public class MQUtil {

    @Resource
    private RocketMQConfig rocketMQConfig;


    /**
     * 同步发送普通消息
     * @param content  消息的内容
     * @param tag  消息的标签 可以理解为区分同一个主题下的消息分类，细化消息,
     *             方便Consumer消费者指定过滤条件在消息队列
     */
    public void sendMessage(String content){
        Message message=new Message();
        message.setBody(content.getBytes());
        message.setTopic(RocketMQConfig.TOPIC);
        this.sentCustomerMessage(message);
    }


    /**
     *
     * @param content 消息内容
     * @param tag 消息标签
     * @param delayTime 定时时间
     */
    public void sendDelayMessage(String content,String tag,Long delayTime){
        Message message=new Message();
        message.setBody(content.getBytes());
        message.setTopic(RocketMQConfig.TOPIC);
        message.setTag(tag);
        /**
         * 单位毫秒（ms）
         * 在指定时间内，当前时间之后投递
         * 例如：2021-01-26 16:21:00 投递
         * 如果被设置成当前时间之前的某一个时刻，消息将立即投递给消费者
         */
        message.setStartDeliverTime(System.currentTimeMillis()+delayTime);
        this.sentCustomerMessage(message);
    }

    private void sentCustomerMessage(Message message){
        Properties properties =rocketMQConfig.getProperties();
        Producer producer = ONSFactory.createProducer(properties);
        //在发送消息之前，必须使用start 方法来启动Producer,只需要调用一次即可
        producer.start();
        try{
            SendResult sendResult = producer.send(message);
            //同步发送消息，只要不抛出异常就是成功
            if(sendResult!=null){
                log.info("消息发送成功：messageId:"+sendResult.getMessageId());
            }
        }catch (Exception e){
            //消息发送失败，需要进行重试

        }

    }

}
