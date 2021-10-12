package com.nicholas.service.impl;

import com.nicholas.domain.Data;
import com.nicholas.domain.DataUpDown;
import com.nicholas.mapper.DataMapper;
import com.nicholas.service.DataUpDownService;
import com.nicholas.service.UpDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class UpDownServiceImpl implements UpDownService {

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private DataUpDownService dataUpDownService;

    @Override
    @Transactional
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

        Data data = new Data();
        data.setAccuracy(temp);
        data.setTrueSum(trueSum);
        data.setId(dataSrc.getId());
        int i = dataMapper.updateByPrimaryKeySelective(data);//更新data表数据

        DataUpDown dataUpDown = new DataUpDown();
        dataUpDown.setDataUid(dataUid);
        dataUpDown.setUpDown(1);
        dataUpDown.setUserUid(dataSrc.getUid());
        dataUpDown.setTime(new Date());
        Integer j = dataUpDownService.addData(dataUpDown);//插入data_updata表数据

        if( i <= 0 || j <= 0 || null == j){
            log.info("数据操作失败");
            return null;
        }

        return i + j;
    }

    @Override
    @Transactional
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
        int i = dataMapper.updateByPrimaryKeySelective(data);//更新data表数据

        DataUpDown dataUpDown = new DataUpDown();
        dataUpDown.setDataUid(dataUid);
        dataUpDown.setUpDown(0);
        dataUpDown.setUserUid(dataSrc.getUid());
        dataUpDown.setTime(new Date());
        Integer j = dataUpDownService.addData(dataUpDown);//插入data_updata表数据

        if( i <= 0 || j <= 0 || null == j){
            log.info("数据操作失败");
            return null;
        }
        return i + j;
    }
}
