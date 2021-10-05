package com.jlw.controller;

import com.jlw.domain.Student;
import com.jlw.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
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
    @PostMapping(value = "/addStudent.do")
//    @ResponseBody//转jackson
    public Map addStudent(Student student) throws Exception {
        HashMap hm = new HashMap();
        int nums = service.addStudent(student);
        if (nums>0) {
            //注册成功
            hm.put("code",1);
            hm.put("msg","注册成功");
        }
        return hm;
    }

    @GetMapping(value = "/findStudent.do")
//    @ResponseBody//转jackson
    public Map findStudent(){
        HashMap stuMap = new HashMap();

        ArrayList<Student> students = (ArrayList<Student>) service.findStudents();
        HashMap dataMap = new HashMap();
        dataMap.put("list",students);
        System.out.println(dataMap);

        stuMap.put("data",dataMap);
        stuMap.put("msg","success");
        stuMap.put("code",1);
        return stuMap;
    }
}
