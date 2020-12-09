package com.example.sharding.service;

import com.example.sharding.pojo.User;

import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/9 3:05 下午
 * @Version : 1.0
 * @Description :用户service接口
 **/

public interface UserService {
    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> findList();

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    boolean save(User user);
}
