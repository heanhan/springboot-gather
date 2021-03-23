package com.example.swagger.controller;

import com.example.swagger.pojo.PageParam;
import com.example.swagger.pojo.User;
import com.example.swagger.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/22 5:29 下午
 * @Version : 1.0
 * @Description :
 *
 * API接口注解
 * 常用注解
 * @Api : 用在类上，描述该类的主要作用。
 * @ApiOperation：用在方法上，描述该方法主要作用。
 * @ApiImplicitParams : 用在方法上，包含一组参数说明。
 * @ApiImplicitParam: 用在方法上，用于描述一个参数说明
 *
 *    @ApiImplicitParam 参数说明
 *
 **/

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    @ApiOperation("分页查询所有用户")
    public List<User> getUserById(@RequestBody PageParam pageParam) {
        return new ArrayList<User>();
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public User getUserById(@PathVariable Integer id) {
        return new User();
    }


    @PostMapping("/")
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "北京", required = true)
    })
    public HttpResult addUser(String username, @RequestParam(required = true) String address) {
        return HttpResult.successResult();
    }

    @PutMapping("/{id}")
    @ApiOperation("根据id更新用户的接口")
    public HttpResult updateUserById(@RequestBody User user) {
        return HttpResult.successResult();
    }
}
