package com.example.springbootexception.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Classname User
 * @Description TODO
 * @Date 2022/1/8 11:29 上午
 * @Created by zhaojh0912
 */
@Data
public class User {

    /**
     * 编号
     */
    @NotNull
    private int id;
    /**
     * 姓名
     */
    @NotNull
    private String name;
    /**
     * 年龄
     */
    @NotNull
    private int age;
}
