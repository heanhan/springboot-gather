package com.example.security.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/5 5:04 下午
 * @Version : 1.0
 * @Description :权限封装
 **/

public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
