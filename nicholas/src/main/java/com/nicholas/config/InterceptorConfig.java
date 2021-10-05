package com.nicholas.config;

import com.nicholas.interceptor.FindInterceptor;
import com.nicholas.interceptor.ServiceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ServiceInterceptor())
                .addPathPatterns("/user/**")
                .excludePathPatterns();
        registry.addInterceptor(new FindInterceptor())
                .addPathPatterns("/find/**")
                .excludePathPatterns();
    }
}
