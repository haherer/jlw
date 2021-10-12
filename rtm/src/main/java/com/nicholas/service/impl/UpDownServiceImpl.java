package com.nicholas.service.impl;

import com.nicholas.domain.DataUpDown;
import com.nicholas.mapper.DataMapper;
import com.nicholas.service.DataUpDownService;
import com.nicholas.service.UpDownService;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.Enum.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UpDownServiceImpl implements UpDownService {

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private DataUpDownService dataUpDownService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    @Transactional
    public Integer doUp(String dataUid) {

//        Data dataSrc = dataMapper.selectByUid(dataUid);
        Map<Object, Object> dataSrc = redisUtils.hmget(dataUid);
        if (null == dataSrc){
            log.info("data 数据未找到");
            return null;
        }


        Long trueSum = ( ((Integer) dataSrc.get("trueSum")).longValue() + 1);
        log.info("trueSum值：" + trueSum);
        Long falseSum = ((Integer) dataSrc.get("falseSum")).longValue();
        log.info("falseSum值：" + falseSum);

        Double temp = trueSum.doubleValue() / (trueSum.doubleValue() + falseSum.doubleValue());//计算accuracy结果
        log.info("temp值：" + temp);

        HashMap<String, Object> dataTemp = new HashMap<>();
        dataTemp.put("trueSum" ,trueSum);
        dataTemp.put("accuracy" ,temp);
        redisUtils.hmset(dataUid, dataTemp);
        log.info("dataUid:" + dataUid + ",缓存赋值" + "accuracy:" + temp + ",trueSum:" + trueSum);
//        Data data = new Data();
//        data.setAccuracy(temp);
//        data.setTrueSum(trueSum);
//        data.setId(dataSrc.getId());
//        int i = dataMapper.updateByPrimaryKeySelective(data);//更新data表数据

        DataUpDown dataUpDown = new DataUpDown();
        dataUpDown.setDataUid(dataUid);
        dataUpDown.setUpDown(1);
        dataUpDown.setUserUid((Long) dataSrc.get("uid"));
        dataUpDown.setTime(new Date());
        redisUtils.lSet(RedisKey.DATA_UP_DOWN.getKey(), dataUpDown);
        log.info("放入缓存，key" + RedisKey.DATA_UP_DOWN.getKey() + ",值:" + dataUpDown);
//        Integer j = dataUpDownService.addData(dataUpDown);//插入data_updata表数据
        return 1;
    }

    @Override
    @Transactional
    public Integer doDown(String dataUid) {

        Map<Object, Object> dataSrc = redisUtils.hmget(dataUid);
        if (null == dataSrc){
            log.info("data 数据未找到");
            return null;
        }

        Long trueSum = ( ((Integer) dataSrc.get("trueSum")).longValue());
        log.info("trueSum值：" + trueSum);
        Long falseSum = ((Integer) dataSrc.get("falseSum")).longValue() +1;
        log.info("falseSum值：" + falseSum);
        Double temp = trueSum.doubleValue() / (trueSum.doubleValue() + falseSum.doubleValue());
        log.info("temp值：" + temp);

//        Data data = new Data();
//        data.setAccuracy(temp);
//        data.setFalseSum(falseSum);
//        data.setId(dataSrc.getId());
//        int i = dataMapper.updateByPrimaryKeySelective(data);//更新data表数据
        HashMap<String, Object> dataTemp = new HashMap<>();
        dataTemp.put("falseSum" ,falseSum);
        dataTemp.put("accuracy" ,temp);
        redisUtils.hmset(dataUid, dataTemp);
        log.info("dataUid:" + dataUid + "缓存赋值" + "accuracy:" + temp + ",trueSum:" + trueSum);

        DataUpDown dataUpDown = new DataUpDown();
        dataUpDown.setDataUid(dataUid);
        dataUpDown.setUpDown(1);
        dataUpDown.setUserUid((Long) dataSrc.get("uid"));
        dataUpDown.setTime(new Date());
        redisUtils.lSet(RedisKey.DATA_UP_DOWN.getKey(), dataUpDown);
        log.info("放入缓存，key" + RedisKey.DATA_UP_DOWN.getKey() + ",值:" + dataUpDown);

//        Integer j = dataUpDownService.addData(dataUpDown);//插入data_updata表数据

        return 1;
    }
}
