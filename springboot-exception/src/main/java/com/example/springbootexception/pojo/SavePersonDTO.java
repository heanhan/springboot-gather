package com.example.springbootexception.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Classname User
 * @Description TODO
 * @Date 2022/1/8 11:29 上午
 * @Created by zhaojh0912
 */

@Data
@Accessors(chain = true)
public class SavePersonDTO {

    /**
     * 姓名
     */
    @NotNull
    @Size(min = 2, max = 10)
    private String name;

    /**
     * 年龄
     */
    @NotNull
    @Max(200)
    private Integer age;

    /**
     * 邮箱
     */
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;
}
