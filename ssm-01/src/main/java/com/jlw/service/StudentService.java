package com.jlw.service;


import com.jlw.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student) throws Exception;
    List<Student> findStudents();
    Boolean isRepeatName(String studentName);
}
