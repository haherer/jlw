package com.nicholas.service.impl;

import com.nicholas.domain.Data;
import com.nicholas.mapper.DataMapper;
import com.nicholas.service.UpDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpDownServiceImpl implements UpDownService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public Integer doUp(String dataUid) {

        Data dataSrc = dataMapper.selectByUid(dataUid);
        if (null == dataSrc){
            log.info("data 数据未找到");
            return null;
        }

        Long trueSum = (dataSrc.getTrueSum() + 1);
        log.info("trueSum值：" + trueSum);
        Long falseSum = dataSrc.getFalseSum();
        log.info("falseSum值：" + falseSum);

        Double temp = trueSum.doubleValue() / (trueSum.doubleValue() + falseSum.doubleValue());//计算accuracy结果
        log.info("temp值：" + temp);

//        Double accuracy = temp.doubleValue();
//        log.info("accuracy值：" + accuracy);

        Data data = new Data();
        data.setAccuracy(temp);
        data.setTrueSum(trueSum);
        data.setId(dataSrc.getId());

        int i = dataMapper.updateByPrimaryKeySelective(data);
        if( i <= 0){
            log.info("data 数据更新失败");
            return null;
        }
        return i;
    }

    @Override
    public Integer doDown(String dataUid) {

        Data dataSrc = dataMapper.selectByUid(dataUid);
        if (null == dataSrc){
            log.info("data 数据未找到");
            return null;
        }

        Long trueSum = dataSrc.getTrueSum();
        log.info("trueSum值：" + trueSum);
        Long falseSum = dataSrc.getFalseSum() + 1;
        log.info("falseSum值：" + falseSum);
        Double temp = trueSum.doubleValue() / (trueSum.doubleValue() + falseSum.doubleValue());
        log.info("temp值：" + temp);

        Data data = new Data();
        data.setAccuracy(temp);
        data.setFalseSum(falseSum);
        data.setId(dataSrc.getId());

        int i = dataMapper.updateByPrimaryKeySelective(data);
        if( i <= 0){
            log.info("data 数据更新失败");
            return null;
        }
        return i;
    }
}
