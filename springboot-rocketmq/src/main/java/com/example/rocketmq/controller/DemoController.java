package com.example.rocketmq.controller;

import com.example.rocketmq.constant.MqTopicConstant;
import com.example.rocketmq.rocketmq.MqMsg;
import com.example.rocketmq.rocketmq.RocketMqService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/8 2:11 下午
 * @Version : 1.0
 * @Description :Too
 **/

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private RocketMqService rocketMqService;
    @GetMapping("/send")
    public void send() {
        MqMsg mqMsg = new MqMsg();
        mqMsg.setTopic(MqTopicConstant.DEMO_TOPIC);
        mqMsg.setTags(MqTopicConstant.DEMO_TAG_REGISTERED);
        // 此处可为其他VO对象，替换掉Map
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", "zhangsan");
        userInfo.put("age", "12");
        // 此处可封装为json等格式
        mqMsg.setContent(userInfo.toString());
        // 第一个发送注册消息
        rocketMqService.asyncSend(mqMsg);
        mqMsg.setTags(MqTopicConstant.DEMO_TAG_MODIFY);
        userInfo.put("age", "18");
        // 此处可封装为json等格式
        mqMsg.setContent(userInfo.toString());
        // 发送修改消息
        rocketMqService.asyncSend(mqMsg);
    }
}
