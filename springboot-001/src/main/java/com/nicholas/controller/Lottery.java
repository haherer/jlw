package com.nicholas.controller;

import com.alibaba.fastjson.JSONObject;
import com.nicholas.utils.HttpToJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/lottery")
public class Lottery {
    @GetMapping("dlt")
    public String dlt(){
        JSONObject jsonObject = null;
        try {
            jsonObject = HttpToJson.get("https://webapi.sporttery.cn/gateway/lottery/getDigitalDrawInfoV1.qry?param=85,0&isVerify=1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject value = jsonObject.getJSONObject("value");
        JSONObject dlt = value.getJSONObject("dlt");
        String lotteryDrawResult = dlt.getString("lotteryDrawResult");
        String lotteryDrawNum = dlt.getString("lotteryDrawNum");
        String lotterySaleEndtime = dlt.getString("lotterySaleEndtime");
        String lotteryGameName = dlt.getString("lotteryGameName");

        return lotteryGameName + " " +
                "开奖日期：" + lotterySaleEndtime +
                " 第"+ lotteryDrawNum + "期，" +
                "开奖号码：" + lotteryDrawResult;
    }
}
