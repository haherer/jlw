package com.nicholas.controller;

import com.nicholas.bean.MyBCrypt;
import com.nicholas.bean.ResultController;
import com.nicholas.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
        @Autowired
        private UserServiceImpl userService;

        @Autowired
        private ResultController resultController;

        @Autowired
        private MyBCrypt myBCrypt;

        @PostMapping("/add")
        public ResultController addUser(@RequestParam("account") String account ,
                                        @RequestParam("password") String password){
            log.info("post add请求：" + "account：" + account + " " + "password：" + password);
            Integer i = userService.addUser(account , password);
            if (i > 0){
                resultController.setCode("0");
                resultController.setMsg("注册成功");
                log.info("注册成功");
                return resultController;
            }
            if (i == 0){
                resultController.setCode("1");
                resultController.setMsg("用户名重复");
                log.info("用户名重复");
                return resultController;
            }
            resultController.setCode("-1");
            resultController.setMsg("注册失败，未知错误");
            log.info("注册失败，未知错误");
            return resultController;
        }

        @GetMapping("/login")
        public ResultController login(@RequestParam("account") String account ,
                                      @RequestParam("password") String password,
                                      HttpServletRequest request, HttpServletResponse response){
            Integer i = userService.login(account, password);
            if (i > 0){
                resultController.setCode("1");
                resultController.setMsg("用户名不存在");
                log.info("用户名不存在");
                return resultController;
            }
            if (i == 0){
                resultController.setCode("0");
                resultController.setMsg("登录成功");
                String token = myBCrypt.encode(account);
                request.getSession().setAttribute(account,token);//account为KEY，放入session
                response.addHeader("token",token);
                log.info("登录成功，token：" + token);
                return resultController;
            }
            resultController.setCode("-1");
            resultController.setMsg("密码错误");
            log.info("密码错误");
            return resultController;
        }
}
