package com.example.quartz.service.impl;

import com.example.quartz.emun.ScheduleStatus;
import com.example.quartz.entity.ScheduleJobEntity;
import com.example.quartz.mapper.ScheduleJobMapper;
import com.example.quartz.service.ScheduleJobService;
import com.example.quartz.utils.ScheduleUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 2:15 下午
 * @Version : 1.0
 * @Description :Too
 **/
@Slf4j
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Autowired
    private Scheduler scheduler;

    @Resource
    private ScheduleJobMapper scheduleJobMapper;
    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init(){
        log.info("定时任务开始初始化了......");
        // 获取定时任务列表
        List<ScheduleJobEntity> scheduleJobEntityList = scheduleJobMapper.queryList();
        scheduleJobEntityList.forEach(x -> {
            // 开启库中的定时任务
            ScheduleUtils.createScheduleJob(scheduler, x);
        });
        log.info("定时任务初始化完成了......");
    }
    @Override
    public List<ScheduleJobEntity> queryList(ScheduleJobEntity scheduleJobEntity) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public ScheduleJobEntity queryEntityByParams(ScheduleJobEntity scheduleJobEntity) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int queryTotal() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     *
     * 定时任务的添加
     * @param scheduleJobEntity
     * 添加 @Transactional  防止任务入库后，却由于其他原因，创建定时任务失败
     */

    @Override
    public void add(ScheduleJobEntity scheduleJobEntity) {
        //添加定时任务入库
        scheduleJobMapper.add(scheduleJobEntity);
        // 添加定时任务的状态
        scheduleJobEntity.setStatus(ScheduleStatus.NORMAL.getValue());
        // 创建定时任务
        ScheduleUtils.createScheduleJob(scheduler, scheduleJobEntity);
    }

    /**
     * 更新定时任务
     * @param scheduleJob
     */
    @Override
    public void update(ScheduleJobEntity scheduleJob) {
        // TODO Auto-generated method stub

    }
}
