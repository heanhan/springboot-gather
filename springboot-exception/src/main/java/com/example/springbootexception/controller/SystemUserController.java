package com.example.springbootexception.controller;

import com.example.springbootexception.entity.pojo.SystemUser;
import com.example.springbootexception.result.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Classname SystemUserController
 * @Description TODO
 * @Date 2022/1/8 4:42 下午
 * @Created by zhaojh0912
 */

@RequestMapping(value = "/user")
@RestController
@Slf4j
public class SystemUserController {

    @PostMapping(value = "/addUserInfo")
    public ResultBody addUserInfo(@RequestBody @Valid SystemUser systemUser){
        return ResultBody.success();
    }
}
