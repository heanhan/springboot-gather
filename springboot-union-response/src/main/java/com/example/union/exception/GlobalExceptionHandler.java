package com.example.union.exception;

import com.example.union.vo.ResultCode;
import com.example.union.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2020/11/25 2:17 下午
 * @Version : 1.0
 * @Description :全局异常通知
 **/

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVo<Object> apiExceptionhandler(ApiException e){
        log.error("api异常");
        return new ResultVo<>(ResultCode.FAILE,e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVo<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        log.error("方法参数错误异常");
        List<String> list=new ArrayList<>(10);
        /**
         * 从异常对象中拿到ObjectError对象
         */
        if(!e.getBindingResult().getAllErrors().isEmpty()){
            for (ObjectError error:e.getBindingResult().getAllErrors()) {
                list.add(error.getDefaultMessage().toString());
            }
        }
        return new ResultVo<>(ResultCode.VALIDATE_FAILED,list);
    }
}
