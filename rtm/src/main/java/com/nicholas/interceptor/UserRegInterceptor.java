package com.nicholas.interceptor;

import com.alibaba.fastjson.JSON;
import com.nicholas.utils.StringCheck;
import com.nicholas.vo.ErrorCode;
import com.nicholas.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class UserRegInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取参数
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        //判断账号、密码、手机号是否为空
        if (null == account) {
            Result result = Result.fail(ErrorCode.ACCOUNT_NULL.getCode(), ErrorCode.ACCOUNT_NULL.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            log.info("账号不能为空:" + account);
            return false;
        }
        if (null == password) {
            Result result = Result.fail(ErrorCode.PASSWORD_NULL.getCode(), ErrorCode.PASSWORD_NULL.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            log.info("密码不能为空:" + password);
            return false;
        }
        if (null == phone) {
            Result result = Result.fail(ErrorCode.PHONE_NULL.getCode(), ErrorCode.PHONE_NULL.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            log.info("手机号不能为空:" + phone);
            return false;
        }
        //判断账号、密码、手机号是否符合规则
        if (!StringCheck.userName(account)){
            Result result = Result.fail(ErrorCode.ACCOUNT_CHECK_ERROR.getCode(), ErrorCode.ACCOUNT_CHECK_ERROR.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            log.info("账号不符合要求:" + account);
            return false;
        }
        if (!StringCheck.passWord(password)){
            Result result = Result.fail(ErrorCode.PASSWORD_CHECK_ERROR.getCode(), ErrorCode.PASSWORD_CHECK_ERROR.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            log.info("密码不符合要求:" + password);
            return false;
        }
        if (!StringCheck.phone(phone)){
            Result result = Result.fail(ErrorCode.PHONE_CHECK_ERROR.getCode(), ErrorCode.PHONE_CHECK_ERROR.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            log.info("手机号不符合要求:" + phone);
            return false;
        }
        return true;
    }

}

