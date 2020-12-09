package com.example.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/9 3:01 下午
 * @Version : 1.0
 * @Description :用户信息
 **/

@Data
@TableName(value = "t_user")
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private int id;

    private String username;

    @TableField(value = "org_code")
    private int orgCode;

}
