package com.jlw;

import com.jlw.dao.StudentDao;
import com.jlw.domain.Student;
import com.jlw.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void test01(){
    String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");

        List<Student> students = dao.selectAll();
        for (Student stus: students) {
            System.out.println(stus);
        }
    }

    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");

        Student student = new Student(null,"江",99,"iirr22@mm.com");
        int nums = dao.insertStudent(student);
        System.out.println(nums);
        }

    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService service = (StudentService) ctx.getBean("studentServer");

        Student student = new Student(null,"江",99,"iirr22@mm.com");
        int nums = service.addStudent(student);
        System.out.println(nums);
    }
}
