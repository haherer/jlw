package com.nicholas.interceptor;


import com.alibaba.fastjson.JSON;
import com.nicholas.vo.ErrorCode;
import com.nicholas.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class QueryInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (null == token){
            Result result = Result.fail(ErrorCode.TOKEN_FAIL.getCode(), ErrorCode.TOKEN_FAIL.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            log.info("token不能为空:" + token);
            return false;
        }
        return true;
    }
}
