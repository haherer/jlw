package com.jlw.spbootdemo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
