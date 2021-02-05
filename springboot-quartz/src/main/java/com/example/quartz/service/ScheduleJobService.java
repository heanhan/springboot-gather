package com.example.quartz.service;

import com.example.quartz.entity.ScheduleJobEntity;

import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 2:15 下午
 * @Version : 1.0
 * @Description :Too
 **/

public interface ScheduleJobService {

    /**
     * 查询定时任务列表
     */
    List<ScheduleJobEntity> queryList(ScheduleJobEntity scheduleJobEntity);
    /**
     *
     * @Description: 根据params查询定时任务
     * @author wsq
     * @date 2019-12-20 04:35:12
     */
    public ScheduleJobEntity queryEntityByParams(ScheduleJobEntity scheduleJobEntity);

    /**
     * 查询总数
     */
    int queryTotal();

    /**
     * 保存定时任务
     */
    void add(ScheduleJobEntity scheduleJobEntity);

    /**
     * 更新定时任务
     */
    void update(ScheduleJobEntity scheduleJob);
}
