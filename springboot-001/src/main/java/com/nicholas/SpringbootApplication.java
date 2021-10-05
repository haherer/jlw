package com.nicholas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})//关闭security登录验证
//@MapperScan(basePackages = "com.nicholas.mapper")//注册mapper包下所有mapper
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

    }

}
