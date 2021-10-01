package com.jlw.handler.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//拦截器类，拦截用户请求
public class MyInterceptor implements HandlerInterceptor {
    //预处理方法，Object handler被拦截的controller对象
    //返回布尔
    //控制器方法前执行，验证是否登录，是否有权限访问
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle执行");
        return true;
    }

    //后处理方法，MaV是被拦截的controller对象处理方法的返回值
    //可以修改返回值，做二次修正
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle执行");
    }

    //最后执行的方法
    //请求处理完成后执行，当视图处理完成后
    //一般做资源回收工作，把占用的内存回收
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion执行");
    }
}
