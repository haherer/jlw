package com.nicholas.controller;

import com.nicholas.service.impl.MailServiceImpl;
import com.nicholas.vo.Enum.ErrorCode;
import com.nicholas.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/email")
public class EmailSendController {

    @Autowired
    private MailServiceImpl mailService;

    @PostMapping
    public Result emailSend(@RequestParam("email") String email){
        if(null == email){
            return Result.fail(ErrorCode.NOT_VALUE.getCode(), ErrorCode.NOT_VALUE.getMsg());
        }
        mailService.sendEmail(email);
        return Result.success(null);
    }
}
