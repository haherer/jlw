package com.jlw.controller;

import com.jlw.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

//创建处理器对象
@RequestMapping("/user")
@Controller
public class MyController {
//视图和数据返回
//    @RequestMapping(value = "/some.do" , method = RequestMethod.POST)
//    public ModelAndView doSome(Student student){
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("myname",student.getName());
//        mv.addObject("myage",student.getAge());
//
//        mv.setViewName("show");
//
//        return mv;
//    }

//对象返回
//        @RequestMapping(value = "/some.do" , method = RequestMethod.POST)
//        @ResponseBody//自动转为jackson对象响应给请求者
//        public Student doSome(String name , Integer age){
//            Student student = new Student();
//            student.setName("同学一");
//            student.setAge(20);
//            return student;
//    }

    //list返回
        @RequestMapping(value = "/some.do" , method = RequestMethod.POST)//produces指定编码
        @ResponseBody//自动转为jackson对象响应给请求者
        public List<Student> doSome(String name , Integer age ,Integer c){
            List<Student> students = new ArrayList<>();
            Student student;
            for (int i = 0; i < c; i++) {
                student = new Student();
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
            return students;
        }

}
