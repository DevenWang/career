package com.wangpengcheng.career.config;

import com.wangpengcheng.career.interceptor.CrossFieldInterceptor;
import com.wangpengcheng.career.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wpc on 2017/5/21.
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private CrossFieldInterceptor crossFieldInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor).addPathPatterns("/company/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/*");
        registry.addInterceptor(crossFieldInterceptor);

        super.addInterceptors(registry);
    }
}
