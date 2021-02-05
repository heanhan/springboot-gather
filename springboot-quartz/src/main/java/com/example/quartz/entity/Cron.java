package com.example.quartz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 11:02 上午
 * @Version : 1.0
 * @Description :定时的实体
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cron implements Serializable {

    /**
     * id
     */
    private int id;

    /**
     * 定时
     */
    private String cron;
}
