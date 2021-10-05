package com.nicholas.httpclient;

import com.alibaba.fastjson.JSONObject;
import com.nicholas.utils.HttpToJson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.util.ArrayList;

public class MyHttpClient {
    public static void main(String[] args) throws IOException {

        //GET
        JSONObject jsonObject = HttpToJson.get("https://webapi.sporttery.cn/gateway/lottery/getDigitalDrawInfoV1.qry?param=04,0&isVerify=1");
        //提取key对应的值
//        String result = jsonObject.getString("value");
//        System.out.println("get方式获取：" + result);
        JSONObject value = jsonObject.getJSONObject("value");
        JSONObject dlt = value.getJSONObject("qxc");
        String lotteryDrawResult = dlt.getString("lotteryDrawResult");
        String lotteryDrawNum = dlt.getString("lotteryDrawNum");
        String lotterySaleEndtime = dlt.getString("lotterySaleEndtime");
        String lotteryGameName = dlt.getString("lotteryGameName");

        System.out.println(lotteryGameName + " " +
                           "开奖日期：" + lotterySaleEndtime +
                           " 第"+ lotteryDrawNum + "期，" +
                           "开奖号码：" + lotteryDrawResult);

//        //POST
//        String urlPost = "http://httpbin.org/post";
//        ArrayList<NameValuePair> nvp = new ArrayList<>();
//        nvp.add(new BasicNameValuePair("username","vip"));
//        nvp.add(new BasicNameValuePair("password","secret"));
//        JSONObject jsonObject1 = HttpToJson.post(urlPost, nvp);
//        String result1 = jsonObject1.getString("form");
//        System.out.println("post方式获取：" + result1);
    }
}
