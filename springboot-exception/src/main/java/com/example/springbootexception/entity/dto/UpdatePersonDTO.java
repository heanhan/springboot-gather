package com.example.springbootexception.entity.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Classname User
 * @Description 更新用户DTO类
 * @Date 2022/1/8 11:29 上午
 * @Created by zhaojh0912
 */

@Data
@Accessors(chain = true)
public class UpdatePersonDTO {


    /**
     * 用户id
     */
    @NotNull
    private Long id;

    /**
     * 姓名
     */
    @Size(min = 2, max = 10)
    private String name;

    /**
     * 年龄
     */
    @Max(200)
    private Integer age;

    /**
     * 邮箱
     */
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;
}
