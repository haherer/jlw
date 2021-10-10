package com.nicholas.utils;

//随机生成订单号
public class OrderIdRandom {

    public static String getRandomNum(){
        long l = System.currentTimeMillis();
        double random = Math.random();
        int i = new Double(random).intValue();
        String num = l + "" + i;
        return num;
    }
}

