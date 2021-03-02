package com.example.rabbitmq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/2 11:12 上午
 * @Version : 1.0
 * @Description :
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Serializable {

    private int sort;

    private String message;
}
