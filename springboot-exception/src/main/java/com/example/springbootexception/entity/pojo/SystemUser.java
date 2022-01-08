package com.example.springbootexception.entity.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Classname SystemUser
 * @Description TODO
 * @Date 2022/1/8 4:38 下午
 * @Created by zhaojh0912
 */
@Data
public class SystemUser implements Serializable {

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
