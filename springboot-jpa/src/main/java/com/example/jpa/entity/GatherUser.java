package com.example.jpa.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "用户实体类", description = "GatherUser")
@Data
@Entity
@Table(name = "gather_user")
public class GatherUser implements Serializable {

    @Id
    @ApiModelProperty(value = "userId", required = false)
    private Long userId;

    @Column(name = "user_head_photo")
    @ApiModelProperty(value = "userHeadPhoto", required = false)
    private String userHeadPhoto;

    @Column(name = "user_name")
    @ApiModelProperty(value = "userName", required = false)
    private String userName;

    @Column(name = "nick_name")
    @ApiModelProperty(value = "nickName", required = false)
    private String nickName;

    @Column(name = "age")
    @ApiModelProperty(value = "age", required = false)
    private Integer age;

    @Column(name = "description")
    @ApiModelProperty(value = "id", required = false)
    private String description;

}
