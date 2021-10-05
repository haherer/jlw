package com.jlw.controller;

import com.jlw.pojo.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/stu")
    public Student stuPro(){
        Student stu = new Student("江江",29);
        return stu;
    }

    @PostMapping("/upload")//文件上传
    public Map upload(@RequestParam("file") MultipartFile img){
        HashMap<String, String> imgMap = new HashMap<>();
        imgMap.put("name",img.getOriginalFilename());
        imgMap.put("code","200");
        return imgMap;
    }
}
