package com.example.jpa.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/15 4:30 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -8987146499044811408L;
    /**
     * 通用返回状态
     */
    private Integer code;
    /**
     * 通用返回信息
     */
    private String message;
    /**
     * 通用返回数据
     */
    private T data;
}
