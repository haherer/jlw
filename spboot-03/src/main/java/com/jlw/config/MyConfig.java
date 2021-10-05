package com.jlw.config;

import com.jlw.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration intReg = registry.addInterceptor(new MyInterceptor());
        //指定拦截映射路径
        intReg.addPathPatterns("/**");
        //排除拦截映射路径
        intReg.excludePathPatterns("");

    }
}
