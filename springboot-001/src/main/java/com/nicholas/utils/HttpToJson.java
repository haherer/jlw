package com.nicholas.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class HttpToJson {

    public static JSONObject get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get请求
        HttpGet httpGet = new HttpGet(url);
        //执行get请求，得到response
        CloseableHttpResponse resp = httpClient.execute(httpGet);
        //拿到响应体
        HttpEntity entity = resp.getEntity();
        //转成string类型
        String s = EntityUtils.toString(entity);
        //关闭资源
        EntityUtils.consume(entity);
        //string转json
        return JSON.parseObject(s);
    }

    public static JSONObject post(String url , ArrayList<NameValuePair> entity) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post请求
        HttpPost httpPost = new HttpPost(url);
        //设置请求体
        httpPost.setEntity(new UrlEncodedFormEntity(entity));
        //执行POST请求
        CloseableHttpResponse execute = httpClient.execute(httpPost);
        //获得响应体
        HttpEntity entity1 = execute.getEntity();
        //转成String
        String s = EntityUtils.toString(entity1);
        //关闭资源
        EntityUtils.consume(entity1);
        //string转json
        return JSON.parseObject(s);
    }
}
