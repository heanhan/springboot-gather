package com.example.file.controller;

import com.example.commonutils.pojo.Result;
import com.example.commonutils.pojo.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/6/9 10:06 上午
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @PostMapping(value = "/upLoadFile")
    public Result upLoadFile(MultipartFile uploadFile){
        //先判断时间是否空，空返回提示
        if(uploadFile.isEmpty()){
            return new Result(false, StatusCode.ERROR,"上传文件不能为空！");
        }
        return new Result();

    }
}
