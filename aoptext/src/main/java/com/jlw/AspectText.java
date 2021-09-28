package com.jlw;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.sql.SQLOutput;
import java.util.Date;

@Aspect
public class AspectText {
    long startTime;
    long endTime;

    @Before(value = "execution(public * *..doSome(..))")
    public void myBefore(){
        startTime = System.currentTimeMillis();
        System.out.println("方法开始时间" + new Date());
    }

    @After(value = "execution(public * *..doSome(..))")
    public void myAfter(JoinPoint joinPoint){

        System.out.println(joinPoint.getSignature());
        Object[] obj = joinPoint.getArgs();
        for (Object objs:obj) {
            System.out.println(objs);
        }

        endTime = System.currentTimeMillis();
        System.out.println("方法结束" + new Date());
        System.out.println("耗时" + (endTime-startTime));
    }

    @AfterReturning(value = "execution(public * *..doOther(..))",returning = "res")
    public void myAfterReturning(Object res){
        System.out.println("myAfterReturning获取的范围值：" + res);
        if("abc".equals(res)){
            System.out.println(res + "def");
        }
    }

}
