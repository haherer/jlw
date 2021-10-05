package com.jlw.service;

import com.jlw.dao.StudentDao;
import com.jlw.domain.Student;
import com.jlw.exception.MyUserException;
import com.jlw.exception.NameException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    public int addStudent(Student student) throws MyUserException {
        String sName = student.getName();
        if (isRepeatName(sName)) {
            throw new NameException("用户名重复");
        }
        return studentDao.insertStudent(student);
    }

    public List<Student> findStudents() {
        return studentDao.selectStudents();
    }

    @Override
    public Boolean isRepeatName(String studentName) {
        String sName = studentDao.studentName(studentName);
        if (sName != null) { return true; }
        return false;
    }
}
