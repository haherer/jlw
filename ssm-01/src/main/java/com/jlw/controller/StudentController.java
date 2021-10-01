package com.jlw.controller;

import com.jlw.domain.Student;
import com.jlw.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;

//    @RequestMapping(value = "/addStudent.do",method = RequestMethod.POST)
//    public ModelAndView addStudent(Student student){
//        ModelAndView mv = new ModelAndView();
//        String tips = "注册失败";
//        int nums = 0;
//        try {
//            nums = service.addStudent(student);
//            if (nums>0){
//                //注册成功
//                tips = "学生【" + student.getName().toString() + "】注册成功";
//            }
//        } catch (Exception e) {
//            tips = "用户名重复";
//            e.printStackTrace();
//        }
//        mv.addObject("tips",tips);
//        mv.setViewName("result");
//        return mv;
//    }
//=================================================================
    @RequestMapping(value = "/addStudent.do",method = RequestMethod.POST)
    public ModelAndView addStudent(Student student) throws Exception {
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        int nums = service.addStudent(student);
        if (nums>0) {
            //注册成功
            tips = "学生【" + student.getName().toString() + "】注册成功";
        }
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping(value = "/findStudent.do",method = RequestMethod.POST)
    @ResponseBody//转jackson
    public List<Student> findStudent(Student student){
        ArrayList<Student> students = (ArrayList<Student>) service.findStudents();
        return students;
    }
}
