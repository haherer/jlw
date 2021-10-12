package com.nicholas.service.impl;

import com.nicholas.domain.Data;
import com.nicholas.mapper.DataMapper;
import com.nicholas.service.DataService;
import com.nicholas.utils.OrderIdRandom;
import com.nicholas.utils.RedisGeoUtils;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.Enum.RedisKey;
import com.nicholas.vo.Enum.UserField;
import com.nicholas.vo.UserQueryVo;
import com.nicholas.vo.parms.Release;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

@Slf4j
@Service
@Transactional
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private LevelValueImpl levelValue;

    @Value("${addEmpValue}")
    private Long addEmpValue;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisGeoUtils redisGeoUtils;

    @Override
    public Integer addData(Release release, String account) {

        Long uid = (long) redisUtils.hget(account, UserField.UID.getFiled());

        Data data = new Data();
        data.setUid(uid);
        data.setCreationTime(new Date());
        data.setLongitude(release.getLongitude());
        data.setLatitude(release.getLatitude());
        data.setPoi(release.getPoi());
        data.setContent(release.getContent());
        data.setImgUrl(release.getImgUrl());
        data.setVideoUrl(release.getVideoUrl());
        data.setState(0);
        data.setSort(0);
        data.setHotValue(0L);
        data.setAccuracy(50.00);
        data.setDataUid(OrderIdRandom.getRandomNum());
        data.setTrueSum(0l);
        data.setFalseSum(0l);
        data.setCommentSum(0L);
        data.setCityId(release.getCityId());
        log.info("data赋值完成");

        if(levelValue.addValue(account, addEmpValue)){
            log.info("user 经验值增加");
            int i = dataMapper.insertSelective(data);
            log.info("数据库新增操作结果（大于0表示成功） ：" + i);
            if ( i > 0){
                Long aLong = redisGeoUtils.geoAdd(release.getCityId(), new Point(release.getLongitude(), release.getLatitude()), data.getDataUid());
                log.info("缓存同步位置数据结果：" + aLong);

                HashMap<String, Object> dataMap = new HashMap<>();
                dataMap.put("uid" , data.getUid());
                dataMap.put("creationTime" ,data.getCreationTime());
                dataMap.put("longitude" ,release.getLongitude());
                dataMap.put("latitude" ,release.getLatitude());
                dataMap.put("poi" ,release.getPoi());
                dataMap.put("content" ,release.getContent());
                dataMap.put("imgUrl" ,release.getImgUrl());
                dataMap.put("videoUrl",release.getVideoUrl());
                dataMap.put("state" , 0);
                dataMap.put("sort" , 0);
                dataMap.put("hotValue" ,0);
                dataMap.put("accuracy" , 50.00);
                dataMap.put("dataUid" ,data.getDataUid());
                dataMap.put("trueSum" , 0);
                dataMap.put("falseSum" ,0);
                dataMap.put("commentSum" ,0);
                dataMap.put("cityId" , release.getCityId());
                redisUtils.hmset(data.getDataUid() , dataMap);
                log.info("data缓存赋值完成");
            }
            return i;
        }
        log.info("user 经验值增加失败，发布失败");
        return null;
    }
}
