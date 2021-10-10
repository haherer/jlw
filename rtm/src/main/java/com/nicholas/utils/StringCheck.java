package com.nicholas.utils;

import java.util.regex.Pattern;

//字符串验证规则
public class StringCheck {

    //用户名：由字母数字下划线组成且开头必须是字母，不能超过16位
    public static Boolean userName(String userName){
        Pattern compile = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{6,16}");
        return compile.matcher(userName).matches();
    }
    //密码：字母或数字构成，不能超过6~16位
    public static Boolean passWord(String passWord){
        Pattern compile = Pattern.compile("[a-zA-Z0-9]{6,16}");
        return compile.matcher(passWord).matches();
    }
    //昵称：字母和数字构成长度大于6小于10
    public static Boolean nickName(String nickName){
        Pattern compile = Pattern.compile("[a-zA-Z0-9]{7,9}");
        return compile.matcher(nickName).matches();
    }
    //手机号：全数字，长度为11位
    public static Boolean phone(String phone){
        Pattern compile = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[5,6])|(17[0-8])|(18[0-9])|(19[1、5、8、9]))\\d{8}$");
        return compile.matcher(phone).matches();
    }
    //邮箱：必须包含@符号；必须包含点；点和@之间必须有字符
    public static Boolean email(String email){
        Pattern compile = Pattern.compile("[@]{1}[a-zA-Z0-9]+[.]+[a-z]+");
        return compile.matcher(email).matches();
    }
}
