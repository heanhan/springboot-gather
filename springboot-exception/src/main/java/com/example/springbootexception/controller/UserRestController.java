package com.example.springbootexception.controller;

import com.example.springbootexception.exceptions.BizException;
import com.example.springbootexception.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserRestController
 * @Description 用户控制层
 * @Date 2022/1/8 11:42 上午
 * @Created by zhaojh0912
 */
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @PostMapping("/user")
    public boolean insert(@RequestBody @Valid User user) {
       log.info("开始新增...");
        //如果姓名为空就手动抛出一个自定义的异常！
//        if(user.getName()==null){
//            throw  new BizException("-1","用户姓名不能为空！");
//        }
        return true;
    }

    @PutMapping("/user")
    public boolean update(@RequestBody User user) {
       log.info("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理
        String str=null;
        str.equals("111");
        return true;
    }

    @DeleteMapping("/user")
    public boolean delete(@RequestBody User user)  {
       log.info("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return true;
    }

    @GetMapping("/user")
    public List<User> findByUser(User user) {
       log.info("开始查询...");
        List<User> userList =new ArrayList<>();
        User user2=new User();
        user2.setId(1);
        user2.setName("xuwujing");
        user2.setAge(18);
        userList.add(user2);
        return userList;
    }
}
