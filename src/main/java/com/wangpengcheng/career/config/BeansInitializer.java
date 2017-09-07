package com.wangpengcheng.career.config;


import com.wangpengcheng.career.interceptor.CrossFieldInterceptor;
import com.wangpengcheng.career.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wpc on 2017/5/21.
 */
@Configuration
public class BeansInitializer {

    @Bean(name = "LoginInterceptor")
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public CrossFieldInterceptor crossFieldInterceptor() {
        return new CrossFieldInterceptor();
    }

}
