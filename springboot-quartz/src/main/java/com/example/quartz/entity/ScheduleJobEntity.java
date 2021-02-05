package com.example.quartz.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 2:01 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Data
public class ScheduleJobEntity implements Serializable {

    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

    /**
     * 任务id
     */
    private Long jobId;

    /**
     * spring bean名称
     */

    private String beanName;

    /**
     * 方法名
     */

    private String methodName;

    /**
     * 参数
     */
    private String params;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;
}
