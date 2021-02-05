package com.example.security.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.example.security.security.JwtAuthenticatioToken;
import com.example.security.utils.SecurityUtils;
import com.example.security.vo.HttpResult;
import com.example.security.vo.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author :zhaojh0912
 * @Date : 2021/2/5 4:02 下午
 * @Version : 1.0
 * @Description :登录控制器
 **/

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录接口
     *
     *
     * 注意：如果使用此登录控制器触发登录认证，需要禁用登录认证过滤器，即将 WebSecurityConfig 中的以下配置项注释即可，
     * 否则访问登录接口会被过滤拦截，执行不会再进入此登录接口，大家根据使用习惯二选一即可。
     *
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);

        return HttpResult.ok(token);
    }

}

