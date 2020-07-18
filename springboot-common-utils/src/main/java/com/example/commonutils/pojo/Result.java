package com.example.commonutils.pojo;

import lombok.Data;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/20 1:28 下午
 */

@Data
public class Result {

    /**
     * 请求响应标识  success /false
     */
    private boolean flag;

    /**
     * 请求响应编码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 无参构造
     */
    public Result(){};

    /**
     * 无数据返回构造
     * @param flag
     * @param code
     * @param message
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    /**
     * 带有返回的值的构造函数
     * @param flag 响应是否成功
     * @param code 响应状态码
     * @param message 响应的信息
     * @param data 返回的数据
     */
    public Result(boolean flag, Integer code, String message,Object data){
        this.flag=false;
        this.code=code;
        this.message=message;
        this.data=data;
    }

    
}
