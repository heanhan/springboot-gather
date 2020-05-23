package com.example.commonutils.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/20 1:28 下午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    
}
