package com.example.webflux.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author :zhaojh0912
 * @Date : 2021/1/25 9:28 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Data
public class City implements Serializable {
    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;

}
