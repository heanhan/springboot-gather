package com.example.springbootexception.enmus;

import com.example.springbootexception.exceptions.BaseErrorInfoInterface;

/**
 * @Classname CommonEnum
 * @Description TODO
 * @Date 2022/1/8 10:58 上午
 * @Created by zhaojh0912
 */
public enum CommonEnum implements BaseErrorInfoInterface {


    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
    PARAMTER_ERROR("600","参数校验失败，请核对参数!");

    /** 错误码 */
    private String resultCode;

    /** 错误描述 */
    private String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}
