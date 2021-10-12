package com.nicholas.nicholas;



import com.nicholas.utils.RedisGeoUtils;
import com.nicholas.utils.RedisUtils;

import com.nicholas.vo.redis.DataPosition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class NicholasApplicationTests {


    @Autowired
    private RedisGeoUtils redisGeoUtils;

    @Test
    void contextLoads() {


        redisGeoUtils.geoAdd("001" , new Point(121.454975 , 31.330128) ,"1000001");
        redisGeoUtils.geoAdd("001" , new Point(121.4483130 , 31.330866) ,"1000002");
        redisGeoUtils.geoAdd("001" , new Point(80.00 , 80.00) ,"1000003");
        redisGeoUtils.geoAdd("001" , new Point(80.00 , 80.00) ,"1000004");
        redisGeoUtils.geoAdd("001" , new Point(80.00 , 80.00) ,"1000005");

        String cityId = "001";
        Double lng = 121.431784;
        Double lat = 31.335496;

        //设置一个附近距离，以及距离单位
        Distance distance = new Distance(3, Metrics.KILOMETERS);

        //创建一个半径对象，传入查询坐标、半径距离和单位
        Circle circle = new Circle(new Point(lng , lat), distance);
//        Circle circle = new Circle(lng, lat, Metrics.KILOMETERS.getMultiplier());
        //调用方法查询，获得结果results
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisGeoUtils.nearByXY(cityId, circle, 1);
        System.out.println("查询附近发布数据：" + results);

        //创建一个数组用于存放遍历结果
        List<DataPosition> list = new ArrayList<>();
        //对结果遍历
        results.forEach(item -> {
//            GeoLocation<String> location = item.getContent();
            Point point = item.getContent().getPoint();
            DataPosition position = DataPosition.builder().cityCode(cityId).dataId(item.getContent().getName())
                    .lng(point.getX()).lat(point.getY()).km(item.getDistance().getValue()).build();
            list.add(position);
        });

        for (DataPosition l:list) {
            System.out.println(l);
        }

    }
}
