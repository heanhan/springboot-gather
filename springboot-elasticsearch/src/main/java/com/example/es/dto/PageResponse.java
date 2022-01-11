package com.example.es.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname PageResponse
 * @Description TODO
 * @Date 2022/1/11 9:37 下午
 * @Created by zhaojh0912
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> implements Serializable {

    private long total;

    private List<T> result;

    private String scrollId;
}
