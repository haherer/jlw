package com.jlw;

import com.github.pagehelper.PageHelper;
import com.jlw.dao.StudentDao;
import com.jlw.daomain.Student;
import com.jlw.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    @Test
    public void selectTest(){
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        for (Student stu:students) {
            System.out.println(stu);
        }
    }

    @Test
    public void selectTest1(){
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1001);
        List<Student> students = dao.selectStudent(student);
        for (Student stu:students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }


    @Test
    public void selectTest2(){
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectStudentPra(1003);
        for (Student stu:students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        PageHelper.startPage(2,3);

        List<Student> students = dao.selectAll();
        for (Student stu:students) {
            System.out.println(stu);
        }
    }
}