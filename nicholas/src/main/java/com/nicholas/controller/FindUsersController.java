package com.nicholas.controller;

import com.nicholas.bean.ResultControllerObj;
import com.nicholas.domain.User;
import com.nicholas.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/find")
public class FindUsersController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResultControllerObj resultControllerObj;

    @GetMapping("/user")
    public ResultControllerObj findUser(String account){
        User user = userService.query(account);
        if (null == user){
            resultControllerObj.setCode("1");
            resultControllerObj.setMsg("用户不存在");
            resultControllerObj.setObj(null);
            log.info("用户不存在");
            return resultControllerObj;
        }
        resultControllerObj.setCode("0");
        resultControllerObj.setMsg("查询成功");
        resultControllerObj.setObj(user);
        log.info("查询成功");
        return resultControllerObj;
    }
}
