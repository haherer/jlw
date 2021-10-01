package com.jlw.handler;

import com.jlw.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//控制器增加，增加控制器功能，增加异常处理功能
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NameException.class)//指定抛出的异常类
    public ModelAndView doNameException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",exception.getMessage());
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler//全局异常
    public ModelAndView doOtherException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",exception.getMessage());
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }
}
