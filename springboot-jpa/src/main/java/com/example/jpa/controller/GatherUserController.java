package com.example.jpa.controller;

import com.example.jpa.entity.GatherUser;
import com.example.jpa.service.GatherUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/15 4:09 下午
 */

@Api(tags = "1.0", description = "用户模块", value = "用户模块")
@RequestMapping(value = "/gatherUser")
@RestController
public class GatherUserController {

    @Autowired
    private GatherUserService gatherUserService;

    @PostMapping(value = "/addGatherUser")
    public String addGatherUser(@RequestBody GatherUser gatherUser){
        gatherUserService.addGatherUser(gatherUser);
        return null;
    }

}
