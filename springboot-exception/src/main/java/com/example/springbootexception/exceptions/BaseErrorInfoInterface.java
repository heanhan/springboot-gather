package com.example.springbootexception.exceptions;

/**
 * @Classname BaseErrorInfoInterface
 * @Description 基础的错误信息接口
 * @Date 2022/1/8 10:56 上午
 * @Created by zhaojh0912
 */
public interface BaseErrorInfoInterface {


    /**
     * 错误码
     */
    String getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
