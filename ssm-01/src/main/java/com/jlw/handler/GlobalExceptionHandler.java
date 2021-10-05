package com.jlw.handler;

import com.jlw.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//控制器增加，增加控制器功能，增加异常处理功能
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NameException.class)//指定抛出的异常类
    @ResponseBody
    public Map doNameException(Exception exception){
        HashMap map = new HashMap();
        map.put("msg",exception.getMessage());
        map.put("code",0);
        return map;
    }

    @ExceptionHandler//全局异常
    @ResponseBody
    public Map doOtherException(Exception exception){
        HashMap map = new HashMap();
        map.put("msg",exception.getMessage());
        map.put("code",0);
        return map;
    }
}
