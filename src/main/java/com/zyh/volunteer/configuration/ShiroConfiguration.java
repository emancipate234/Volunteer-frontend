package com.zyh.volunteer.configuration;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //引入安全管理组件SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //登陆页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //成功页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //限制页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/failed");

        HashMap<String, String> filterChainDefinitionMap = new HashMap<>();
        //定义/login请求无需访问权限
        filterChainDefinitionMap.put("/login","anon");
        //定义/index需要reader权限
        filterChainDefinitionMap.put("/index", "perms[read]");
        //定义其他格式的请求需要身份验证
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myShiroRealm());
        return manager;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }
}
