package com.example.union.vo;

import lombok.Getter;

/**
 * @Author :zhaojh0912
 * @Date : 2020/11/25 10:55 上午
 * @Version : 1.0
 * @Description :Too
 **/

@Getter
public enum ResultCode {

    SUCCESS(1000,"操作成功"),
    FAILE(1001,"操作失败"),
    VALIDATE_FAILED(1002,"参数教校验失败"),
    ERROR(1003,"未知错误");
    private int code;
    private String msg;
    ResultCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }


}
