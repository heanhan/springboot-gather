package com.example.quartz.mapper;

import com.example.quartz.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 2:17 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Mapper
public interface ScheduleJobMapper {

    ScheduleJobEntity queryObject(long id);

    List<ScheduleJobEntity> queryList();

    /**
     * 查询定时任务根据params
     * @param scheduleJobEntity
     * @return
     */
    ScheduleJobEntity queryEntityByParams(ScheduleJobEntity scheduleJobEntity);

    /**
     * 添加定时任务
     * @param scheduleJobEntity
     */
    void add(ScheduleJobEntity scheduleJobEntity);

    /**
     * 更新定时任务
     * @param scheduleJobEntity
     * @return
     */
    int update(ScheduleJobEntity scheduleJobEntity);

    /**
     * 删除定时任务
     * @param jobId
     * @return
     */
    int delete(Long jobId);

    /**
     * 查找数据总数
     * @return
     */
    int queryTotal();
}
