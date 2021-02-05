package com.example.quartz.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/4 2:57 下午
 * @Version : 1.0
 * @Description :Too
 **/

public class ThreadPoolUtils {

    private static final ExecutorService threadPool;

    static {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = Runtime.getRuntime().availableProcessors() * 2;
        long keepAliveTime = 5;
        TimeUnit keepAliveTimeUnit = TimeUnit.MINUTES;
        int queSize = 100_000;
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ThreadPoolUtils")
                .build();

        threadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, keepAliveTimeUnit, new ArrayBlockingQueue<>(queSize)
                , threadFactory);
    }


    /**
     * 获取线程池
     * @return 线程池
     */
    public static ExecutorService getThreadPool() {
        return threadPool;
    }
}
