package com.jlw;

import com.jlw.dao.StudentDao;
import com.jlw.domain.Goods;
import com.jlw.domain.Sale;
import com.jlw.domain.Student;
import com.jlw.service.GoodsService;
import com.jlw.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
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

        Student student = new Student(null,"江",99,"iirr22@mm.com",new Date());
        int nums = dao.insertStudent(student);
        System.out.println(nums);
        }

    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService service = (StudentService) ctx.getBean("studentServer");

        Student student = new Student(null,"江",4,"iirr22@mm.com",new Date());
        int nums = service.addStudent(student);
        System.out.println(nums);

    }

    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        GoodsService service = (GoodsService) ctx.getBean("goodsService");

        Goods good = service.queryGood(1001);
        System.out.println(good);

        Sale sale = service.queryNums(1001);
        System.out.println(sale);
    }

    @Test
    public void test05(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        GoodsService service = (GoodsService) ctx.getBean("goodsService");

//        service.setNums(1002);
          service.buy(1002, 3000F);
    }

}
