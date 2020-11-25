package com.example.union.vo;

import lombok.Data;

/**
 * @Author :zhaojh0912
 * @Date : 2020/11/25 10:52 上午
 * @Version : 1.0
 * @Description :Too
 **/

@Data
public class ResultVo<T>{

    /**
     * 状态码 返回的编码
     */
    private int code;

    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;

    /**
     * 具体响应的数据
     */
    private T data;

    public ResultVo (T data){
        this(ResultCode.SUCCESS,data);
    }
    public ResultVo(ResultCode resultCode,T data){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
        this.data=data;
    }

}
