package com.example.springbootexception.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname User
 * @Description 用户VO类
 * @Date 2022/1/8 11:29 上午
 * @Created by zhaojh0912
 */

@Data
@Accessors(chain = true)
public class PersonVO {

    /**
     *
     */
    private Long id;

    /**
     *姓名
     */
    private String name;

    /**
     *年龄
     */
    private Integer age;

    /**
     *邮箱
     */
    private String email;
}
