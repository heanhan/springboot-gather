package com.example.jpa.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户信息  约定 该类是为单表操作的demo
 * @author zhaojh0912
 */
@Data
@Entity
@Table(name = "gather_user")
public class GatherUser implements Serializable {

    /**
     * 用户id
     */
    @Id
    private Long userId;

    /**
     * 用户头像
     */
    @Column(name = "user_head_photo")
    private String userHeadPhoto;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 个人描述
     */
    @Column(name = "description")
    private String description;

}
