package com.nicholas.config;

import com.nicholas.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPatterns = {"/user/**"};//加入拦截路径
        String[] excludePathPatterns = {"/user/find"};//排除拦截路径

        registry.addInterceptor(new MyInterceptor()).
                 addPathPatterns(addPathPatterns).
                 excludePathPatterns(excludePathPatterns);
    }
}
