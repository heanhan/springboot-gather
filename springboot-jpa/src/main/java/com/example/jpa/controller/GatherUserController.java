package com.example.jpa.controller;

import com.example.jpa.api.GatherUserApiService;
import com.example.jpa.entity.GatherUser;
import com.example.jpa.service.GatherUserService;
import com.example.jpa.vo.GatherUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/15 4:09 下午
 */
@RequestMapping(value = "/gatherUser")
@RestController
public class GatherUserController {

    @Autowired
    @Qualifier(value = "gatherUserApiServiceImpl")
    private GatherUserApiService gatherUserApiService;

    @PostMapping(value = "/addGatherUser")
    public String addGatherUser(@RequestBody GatherUserVo gatherUserVo){
        /**
         * 业务实现逻辑
         * 1、首先进行vo与实体的类进行转换
         * 2、
         */
        gatherUserApiService.addGatherUser(gatherUserVo);
        return null;
    }

}
