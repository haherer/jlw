package com.nicholas.service.impl;

import com.nicholas.utils.EmailSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailServiceImpl {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Async //异步方法
    public void sendEmail(String email){

        try {
            String code = "您的验证码:" + (int)((Math.random()*9+1)*100000);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("rem_验证码");
            simpleMailMessage.setText(code);
            simpleMailMessage.setTo(email);
            simpleMailMessage.setFrom("rtm_nicholas@outlook.com");
            javaMailSender.send(simpleMailMessage);
            log.info("邮件请求已发送");
        }catch (MailException e){
            e.printStackTrace();
            log.info("邮件发送失败");
        }
    }
}
