package com.jlw.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }

    @RequestMapping("/hi")
    public String hi(){
        System.out.println("hi");
        return "hi";
    }
}
