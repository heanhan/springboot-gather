package com.example.security.security;

import com.example.security.pojo.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author :zhaojh0912
 * @Date : 2021/2/5 5:08 下午
 * @Version : 1.0
 * @Description :Too
 **/

public class JwtUserDetails extends User {

    private static final long serialVersionUID = 1L;

    public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, true, true, true, true, authorities);
    }

    public JwtUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}

