package com.nicholas.service.impl;

import com.nicholas.domain.Data;
import com.nicholas.service.DataServiceFromRedis;
import com.nicholas.utils.RedisGeoUtils;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.parms.NearDataList;
import com.nicholas.vo.redis.DataPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceFromRedisImpl implements DataServiceFromRedis {

    @Autowired
    private RedisGeoUtils redisGeoUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<DataPosition> nearDataList(NearDataList nearDataList) {//分页还没实现。先用size属性赋值

        //设置一个附近距离，以及距离单位
        Distance distance = new Distance(nearDataList.getNear(), Metrics.KILOMETERS);

        //创建一个半径对象，传入查询坐标、半径距离和单位
        Circle circle = new Circle(new Point(nearDataList.getLng(), nearDataList.getLat()), distance);
//        Circle circle = new Circle(lng, lat, Metrics.KILOMETERS.getMultiplier());
        //调用方法查询，获得结果results
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisGeoUtils.nearByXY(nearDataList.getCityId(), circle, nearDataList.getPageSize());
//        System.out.println("查询附近发布数据：" + results);

        //创建一个数组用于存放遍历结果
        List<DataPosition> list = new ArrayList<>();
        //对结果遍历
        results.forEach(item -> {
//            GeoLocation<String> location = item.getContent();
            Point point = item.getContent().getPoint();
            String dataUid = item.getContent().getName();

            Map<Object, Object> dataMap = redisUtils.hmget(dataUid);

            Integer commentSum = (Integer) dataMap.get("commentSum");
            long l = commentSum.longValue();

            Integer falseSum = (Integer) dataMap.get("falseSum");
            long l1 = falseSum.longValue();

            Integer hotValue = (Integer) dataMap.get("hotValue");
            long l2 = hotValue.longValue();

            Integer trueSum = (Integer) dataMap.get("trueSum");
            long l3 = trueSum.longValue();

            DataPosition position = DataPosition.builder().cityCode(nearDataList.getCityId()).dataId(dataUid)
                    .lng(point.getX()).lat(point.getY()).km(item.getDistance().getValue()).accuracy((double)dataMap.get("accuracy"))
                    .commentSum(l).content((String) dataMap.get("content")).creationTime(new Date((long)dataMap.get("creationTime")))
                    .falseSum(l1).hotValue(l2).imgUrl((String) dataMap.get("imgUrl"))
                    .nickName((String) dataMap.get("nickName")).poi((String) dataMap.get("poi")).trueSum(l3)
                    .uid((long) dataMap.get("uid")).videoUrl((String) dataMap.get("videoUrl")).build();
            list.add(position);
        });
        return list;
    }
}
