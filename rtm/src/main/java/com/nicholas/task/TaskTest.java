package com.nicholas.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class TaskTest {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    //@Scheduled(cron = "0/10 * * * * *") //cron表达式，秒 分 时 日 月 周
    public void test(){
            try {
                String code = "6个8就不发了，这次是:" + (int)((Math.random()*9+1)*100000);
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setSubject("球球我要吃泡面");
                simpleMailMessage.setText(code);
                simpleMailMessage.setTo("32714214@qq.com");
                simpleMailMessage.setFrom("rtm_nicholas@outlook.com");
                javaMailSender.send(simpleMailMessage);
                log.info("邮件请求已发送");
            }catch (MailException e){
                e.printStackTrace();
                log.info("邮件发送失败");
            }
    }
}
