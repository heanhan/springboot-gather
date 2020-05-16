package com.example.jpa.controller;

import io.swagger.annotations.Api;
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

}
