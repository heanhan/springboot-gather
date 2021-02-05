package com.example.quartz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 11:09 上午
 * @Version : 1.0
 * @Description :Too
 **/

@Mapper
public interface JobMapper {

    /**
     * 通过id 获取定时规则
     * @return
     */
    @Select("select cron from cron where id = 1")
    String getCronById();
}
