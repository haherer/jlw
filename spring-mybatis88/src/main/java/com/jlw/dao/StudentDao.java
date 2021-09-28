package com.jlw.dao;

import com.jlw.domain.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectAll();
}
