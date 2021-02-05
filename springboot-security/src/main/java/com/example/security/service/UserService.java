package com.example.security.service;

import com.example.security.pojo.User;

import java.util.Set;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/5 4:53 下午
 * @Version : 1.0
 * @Description :Too
 **/

public interface UserService {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 查找用户的菜单权限标识集合
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);
}
