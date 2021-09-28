package com.jlw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        doSome doSome = (doSome) ctx.getBean("doSome");

        doSome.doSome("jj",6);
    }

    @org.junit.Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        doOther doOther = (com.jlw.doOther) ctx.getBean("doOther");

        doOther.doOther();
    }
}
