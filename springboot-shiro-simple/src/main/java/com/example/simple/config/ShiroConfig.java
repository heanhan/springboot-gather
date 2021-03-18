package com.example.simple.config;

import com.example.simple.shirocore.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author :zhaojh0912
 * @Date : 2021/3/18 2:26 下午
 * @Version : 1.0
 * @Description :Too
 **/

@Configuration
public class ShiroConfig {

    /**
     * 在这个配置类中只做三件事
     * 1、创建Realm 的实例
     * 2、需要配置一个SecurityManager,在SecurityManager 中配置Realm
     * 3、配置一个 ShiroFilterFactoryBean ，在 ShiroFilterFactoryBean 中指定路径拦截规则等。
     *      补充第三步：ShiroFilterFactoryBean 的配置稍微多一些，配置含义如下：
     *      3.1. setSecurityManager 表示指定 SecurityManager。
     *      3.2. setLoginUrl 表示指定登录页面。
     *      3.3. setSuccessUrl 表示指定登录成功页面。
     *      3.4. 接下来的 Map 中配置了路径拦截规则，注意，要有序。
     */


    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }


    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/unauthorizedurl");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/doLogin", "anon");
        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
}
