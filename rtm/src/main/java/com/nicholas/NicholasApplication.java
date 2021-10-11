package com.nicholas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //开启定时任务
@EnableAsync //开启异步任务
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})//关闭security登录验证
public class NicholasApplication {

    public static void main(String[] args) {
        SpringApplication.run(NicholasApplication.class, args);
    }

}
