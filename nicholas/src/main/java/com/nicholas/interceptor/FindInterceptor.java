package com.nicholas.interceptor;

import com.alibaba.fastjson.JSON;
import com.nicholas.bean.ResultController;
import com.nicholas.utils.StringCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class FindInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String account = request.getParameter("account");//请求中获取account
        String token = request.getHeader("token");//请求头中获取token
        String attributeToken = (String) request.getSession().getAttribute(account);//session中获取token

        if (null == account || !StringCheck.userName(account)){
            ResultController resultController = new ResultController("1", "账号不能为空或账号格式错误");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultController));
            log.info("账号不能为空或账号格式错误");
            return false;
        }
        if (null == token){
            ResultController resultController = new ResultController("1", "token不能为空");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultController));
            log.info("token不能为空");
            return false;
        }
        //判断请求头中的token与session中的token是否一致
        if(null == attributeToken || !token.equals(attributeToken)){
            ResultController resultController = new ResultController("1", "token失效，请重新登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultController));
            log.info("token失效，请重新登录");
            return false;
        }
        return true;
    }
}
