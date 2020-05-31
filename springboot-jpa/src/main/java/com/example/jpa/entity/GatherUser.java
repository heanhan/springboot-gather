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

    @Id
    private Long userId;

    @Column(name = "user_head_photo")
    private String userHeadPhoto;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "description")
    private String description;

}
