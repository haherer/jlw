package com.jlw;

public class doOtherImpl implements doOther{
    @Override
    public String doOther() {
        System.out.println("doOther执行");
        return "abc";
    }
}
