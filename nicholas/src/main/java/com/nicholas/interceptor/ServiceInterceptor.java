package com.nicholas.interceptor;

import com.alibaba.fastjson.JSON;
import com.nicholas.bean.ResultController;
import com.nicholas.utils.StringCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ServiceInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (null == account || null == password){
            ResultController resultController = new ResultController("1", "用户名或密码不能为空");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultController));
            log.info("用户名或密码不能为空");
            return false;
        }
        if(!StringCheck.userName(account)){
            ResultController resultController = new ResultController("1", "用户名：由字母数字下划线组成且开头必须是字母，不能超过16位");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultController));
            log.info("用户名：由字母数字下划线组成且开头必须是字母，不能超过16位");
            return false;
        }
        if(!StringCheck.passWord(password)){
            ResultController resultController = new ResultController("1", "密码：字母和数字构成，6~16位");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultController));
            log.info("密码：字母和数字构成，6~16位");
            return false;
        }
        return true;
    }
}
