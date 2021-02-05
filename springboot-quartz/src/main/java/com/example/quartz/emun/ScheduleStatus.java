package com.example.quartz.emun;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 2:09 下午
 * @Version : 1.0
 * @Description :Too
 **/

public enum ScheduleStatus {

    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 暂停
     */
    PAUSE(1);

    private int value;

    private ScheduleStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
