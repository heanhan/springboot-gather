package com.example.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/22 5:32 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户类")
public class User implements Serializable {

    @ApiModelProperty("用户唯一id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("地址")
    private String address;
}
