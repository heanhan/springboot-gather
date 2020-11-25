package com.example.union.exception;

import com.example.union.vo.ResultVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import sun.jvm.hotspot.runtime.ObjectMonitor;

/**
 * @Author :zhaojh0912
 * @Date : 2020/11/25 2:41 下午
 * @Version : 1.0
 * @Description :全局处理增强版的controller，避免controller里返回数据每次都要用响应体来包装
 **/
@RestControllerAdvice(basePackages = {"com.example,union.controller"})// 需要加上扫描的包
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果接口返回的类型本身就是ResultVo 那就没有必要进行额外的操作
        return !methodParameter.getGenericParameterType().equals(ResultVo.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //String类型不能直接包装，所以要进行一些特殊处理
        if(methodParameter.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper=new ObjectMapper();
            try{
                //将数据包装在ResultVo里后再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new ResultVo<>(data));
            }catch (JsonProcessingException e){
                throw new ApiException();
            }
        }
        //将原本的数据包装再resultVo里ß
        return new ResultVo<>(data);
    }
}
