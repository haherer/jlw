package com.nicholas.service;

import com.nicholas.domain.Student;

import java.util.List;

public interface StudentService {

    Student queryStudentById(Integer id);

    Object updateStudentById(Integer id,Integer age);

    List<Student> queryStudentAll();

    Boolean addStudent(Student student);
}
