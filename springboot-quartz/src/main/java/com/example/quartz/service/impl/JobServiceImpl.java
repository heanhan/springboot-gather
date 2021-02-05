package com.example.quartz.service.impl;

import com.example.quartz.mapper.JobMapper;
import com.example.quartz.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 11:09 上午
 * @Version : 1.0
 * @Description :Too
 **/

@Service
public class JobServiceImpl implements JobService {

    @Resource
    private JobMapper jobMapper;

    @Override
    public String getCronById(){
        String cronById = jobMapper.getCronById();
        return cronById;
    }


}
