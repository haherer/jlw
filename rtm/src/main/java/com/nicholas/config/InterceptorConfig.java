package com.nicholas.config;

import com.nicholas.interceptor.QueryInterceptor;
import com.nicholas.interceptor.UserLoginInterceptor;
import com.nicholas.interceptor.UserRegInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserRegInterceptor())
                .addPathPatterns("/user/register")
                .excludePathPatterns();
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/user/login")
                .excludePathPatterns();
        registry.addInterceptor(new QueryInterceptor())
                .addPathPatterns("/query/**" , "/release/**" ,"/levelValue/**" ,"/comment/**")
                .excludePathPatterns();
    }
}
