package com.jlw.springboot;

import com.jlw.springboot.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    private Student student;
    @Test
    void contextLoads() {
        System.out.println(student);
    }

}
