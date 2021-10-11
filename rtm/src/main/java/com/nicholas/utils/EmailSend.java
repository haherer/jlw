package com.nicholas.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailSend {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void emailSend(String email) throws MailException{

        String code = "您的验证码:" + ((Math.random()*9+1)*100000);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("rem_验证码");
        simpleMailMessage.setText(code);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("rtm_nicholas@outlook.com");

        javaMailSender.send(simpleMailMessage);
        log.info("邮件请求已发送");
    }
}
