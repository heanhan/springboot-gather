package com.example.jpa.api.impl;


import com.example.jpa.api.GatherUserApiService;
import com.example.jpa.entity.GatherUser;
import com.example.jpa.service.GatherUserService;
import com.example.jpa.vo.GatherUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * 用户的接口层
 * @author zhaojh0912
 */

@Service(value = "gatherUserApiServiceImpl")
public class GatherUserApiServiceImpl implements GatherUserApiService {

    @Autowired
    @Qualifier(value = "gatherUserServiceImpl")
    private GatherUserService gatherUserServiceImpl;
    /**
     * 添加用户
     *
     * @param gatherUserVo
     */
    @Override
    public String addGatherUser(GatherUserVo gatherUserVo) {
        GatherUser gatherUser=new GatherUser();
        BeanCopier beanCopier = BeanCopier.create(GatherUserVo.class, GatherUser.class, true);
        beanCopier.copy(gatherUserVo,gatherUser,null);
        if(gatherUserServiceImpl.addGatherUser(gatherUser)){
            return "create user success!";
        }
        return "create user fail!";
    }
}
