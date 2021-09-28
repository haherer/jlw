package com.jlw.dao;

import com.jlw.daomain.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();

    List<Student> selectStudent(Student student);

    List<Student> selectStudentPra(@Param("id") Integer id);

    List<Student> selectAll();
}
