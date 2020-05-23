package com.example.jpa.service.impl;

import com.example.jpa.dao.GatherUserDao;
import com.example.jpa.entity.GatherUser;
import com.example.jpa.service.GatherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/16 11:29 上午
 */
@Service
public class GatherUserServiceImpl implements GatherUserService {

    @Autowired
    private GatherUserDao gatherUserDao;

    @Override
    public boolean addGatherUser(GatherUser gatherUser) {
        GatherUser user = gatherUserDao.save(gatherUser);
        if(null!=user){
            return true;
        }
        return false;
    }
}
