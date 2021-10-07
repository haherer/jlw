package com.nicholas.controller;

import com.nicholas.service.UserService;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.UserReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result userRegister(@RequestBody UserReg user){
        if (userService.isAccount(user.getAccount())){
            return Result.fail(101,"账号已存在");
        }
        if (userService.isPhone(user.getPhone())){
            return Result.fail(102,"手机后已存在");
        }
        return userService.register(user);
    }
}
