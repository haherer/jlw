package com.nicholas.service.impl;

import com.nicholas.domain.DataUpDown;
import com.nicholas.mapper.DataUpDownMapper;
import com.nicholas.service.DataUpDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataUpDownServiceImpl implements DataUpDownService {

    @Autowired
    private DataUpDownMapper dataUpDownMapper;

    @Override
    public Integer addData(DataUpDown data) {

        if (null == data){return null;}

        return dataUpDownMapper.insertSelective(data);
    }
}
