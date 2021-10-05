package com.nicholas.config;

import com.nicholas.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //过滤器配置类
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        //注册过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());

        //过滤路径
        filterRegistrationBean.addUrlPatterns("/user/*");

        return filterRegistrationBean;
    }


}
