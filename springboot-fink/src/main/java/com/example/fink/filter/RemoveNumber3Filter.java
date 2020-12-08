package com.example.fink.filter;

import org.apache.flink.api.common.functions.FilterFunction;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/5 2:04 下午
 * @Version : 1.0
 * @Description :Too
 **/

public class RemoveNumber3Filter  implements FilterFunction<Integer> {

    @Override
    public boolean filter(Integer i) throws Exception {
        return i != 3;
    }
}
