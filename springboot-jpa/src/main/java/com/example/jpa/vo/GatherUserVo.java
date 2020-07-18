package com.example.jpa.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description  用户的 实体类
 * @Date 2020/5/15 3:11 下午
 * @author by zhaojh0912
 */
@Data
public class GatherUserVo implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户头像
     */
    private String userHeadPhoto;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 个人描述
     */
    private String description;

}
