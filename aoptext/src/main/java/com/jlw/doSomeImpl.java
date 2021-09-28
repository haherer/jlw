package com.jlw;

public class doSomeImpl implements doSome {
    @Override
    public void doSome(String name , Integer age) {
        System.out.println("doSome执行");
    }
}
