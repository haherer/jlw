package com.nicholas.controller;

import com.nicholas.bean.MyBCrypt;
import com.nicholas.domain.User;
import com.nicholas.service.UserService;
import com.nicholas.utils.JWTUtils;
import com.nicholas.vo.ErrorCode;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.UserLog;
import com.nicholas.vo.parms.UserReg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MyBCrypt myBCrypt;

    @PostMapping ("/register")
    public Result userRegister(UserReg user){

        if (userService.isAccount(user.getAccount())){
            log.info("注册失败，账号已存在");
            return Result.fail(ErrorCode.REGISTER_ACCOUNT_REPEAT.getCode(), ErrorCode.REGISTER_ACCOUNT_REPEAT.getMsg());
        }

        if (userService.isPhone(user.getPhone())){
            log.info("注册失败，手机号已存在");
            return Result.fail(ErrorCode.REGISTER_PHONE_REPEAT.getCode(), ErrorCode.REGISTER_PHONE_REPEAT.getMsg());
        }
        log.info("注册成功");
        return userService.register(user);
    }

    @Transactional
    @PostMapping("/login")
    public Result userLogin(UserLog userLog){

        if (!userService.isAccount(userLog.getAccount())){
            log.info("账号不存在");
            return Result.fail(ErrorCode.LOGIN_ERROR.getCode(), ErrorCode.LOGIN_ERROR.getMsg());
        }
        User user = userService.login(userLog);
        if (null == user){
            log.info("密码错误");
            return Result.fail(ErrorCode.LOGIN_ERROR.getCode(),ErrorCode.LOGIN_ERROR.getMsg());
        }

        if (user.getAccountStatus() == 1){
            log.info("账号被冻结");
            return Result.fail(ErrorCode.ACCOUNT_CLOSE.getCode(), ErrorCode.ACCOUNT_CLOSE.getMsg());
        }

        String token = JWTUtils.creatToken((long)user.getUid());
        log.info("生成token：" + token);
        return Result.success(token);

    }

}
