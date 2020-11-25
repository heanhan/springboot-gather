package com.example.union.exception;

import com.example.union.vo.ResultCode;
import lombok.Data;

/**
 * @Author :zhaojh0912
 * @Date : 2020/11/25 2:13 下午
 * @Version : 1.0
 * @Description :自定义异常类
 **/

@Data
public class ApiException  extends RuntimeException{
    private int code;

    private String msg;

    public ApiException(){
        this(ResultCode.FAILE);
    }

    public ApiException(ResultCode resultCode){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
    }
}
