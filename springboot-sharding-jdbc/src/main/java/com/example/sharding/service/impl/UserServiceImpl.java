package com.example.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sharding.mapper.UserMapper;
import com.example.sharding.pojo.User;
import com.example.sharding.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/9 3:06 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 查询用户列表
     *
     * @return
     */
    @Override
    public List<User> findList() {
        return new User().selectAll();
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        return super.save(user);
    }
}
