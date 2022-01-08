package com.example.springbootexception.pojo.dto;

import com.example.springbootexception.pojo.Job;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Classname User
 * @Description 用户实体类
 * @Date 2022/1/8 11:29 上午
 * @Created by zhaojh0912
 */

@Data
public class UserDTO {

    /**
     *用户id
     */
    @Min(value = 10000000000000000L, groups = Update.class)
    private Long userId;

    /**
     *    用户名
     */
    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 2, max = 10, groups = {Save.class, Update.class})
    private String userName;

    /**
     * 账户
     */
    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String account;

    /**
     * 密码
     */
    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String password;

    /**
     * 工作
     */
    @NotNull(groups = {Save.class, Update.class})
    @Valid
    private Job job;

    /**
     * 保存的时候校验分组
     */
    public interface Save {
    }

    /**
     * 更新的时候校验分组
     */
    public interface Update {
    }
}
