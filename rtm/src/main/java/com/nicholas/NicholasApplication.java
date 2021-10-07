package com.nicholas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})//关闭security登录验证
public class NicholasApplication {

    public static void main(String[] args) {
        SpringApplication.run(NicholasApplication.class, args);
    }

}
