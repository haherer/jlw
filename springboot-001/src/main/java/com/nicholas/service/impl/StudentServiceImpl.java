package com.nicholas.service.impl;

import com.nicholas.domain.Student;
import com.nicholas.mapper.StudentMapper;
import com.nicholas.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Transactional //增加事务
    @Override
    public Object updateStudentById(Integer id,Integer age) {
        Student stu = new Student();
        stu.setId(id);
        stu.setAge(age);
        int i = studentMapper.updateByPrimaryKeySelective(stu);
        return i;
    }

    @Override
    public List<Student> queryStudentAll() {
        List<Student> students = studentMapper.selectAll();
        return students;
    }

    @Override
    public Boolean addStudent(Student student) {
        String name = student.getName();
        Student stuName = studentMapper.selectByName(name);
        if (stuName != null){
            return false;
        }else {
            if (studentMapper.insert(student) > 0){
                return true;
            }
            return false;
        }
    }
}
