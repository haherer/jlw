package com.nicholas.controller;

import com.nicholas.bean.Jiang;
import com.nicholas.domain.Student;
import com.nicholas.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private Jiang jiang;

    @GetMapping("/find")
    public Object findStudent(Integer id){
        return service.queryStudentById(id);
    }

    @GetMapping("/update")
    public Object updataStudent(Integer id,Integer age){
        int count = (int) service.updateStudentById(id, age);
        return "修改成功数据：" + count;
    }

    @GetMapping("/finds")
    public List findStudents(){
        List<com.nicholas.domain.Student> students = service.queryStudentAll();
        return students;
    }

    @GetMapping("/jiang")
    public Jiang jiang(){
        return jiang;
    }

    @GetMapping("/add")
    public Map addStudent(Student student){
        HashMap<String, String> result = new HashMap<>();
        if (service.addStudent(student)){
            result.put("code","200");
            result.put("msg","注册成功");
            return result;
        }else {
            result.put("code","100");
            result.put("msg","用户名重复或注册失败");
            return result;
        }
    }
}
