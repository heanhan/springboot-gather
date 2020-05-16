package com.example.jpa.service;

import com.example.jpa.entity.GatherUser;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/16 11:28 上午
 */
public interface GatherUserService {

    /**
     *  保存用用户信息
     * @param gatherUser
     */
    void addGatherUser(GatherUser gatherUser);
}
