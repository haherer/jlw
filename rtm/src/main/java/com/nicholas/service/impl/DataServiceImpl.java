package com.nicholas.service.impl;

import com.nicholas.domain.Data;
import com.nicholas.mapper.DataMapper;
import com.nicholas.service.DataService;
import com.nicholas.utils.OrderIdRandom;
import com.nicholas.vo.UserQueryVo;
import com.nicholas.vo.parms.Release;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Override

    public Integer addData(Release release, UserQueryVo userQueryVo) {

            Data data = new Data();
            data.setUid(userQueryVo.getUid());
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
            log.info("data赋值完成");

            if(levelValue.addValue(userQueryVo.getAccount(), addEmpValue)){
                return dataMapper.insertSelective(data);
            }
            return null;
    }
}
