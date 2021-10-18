package com.nicholas.service;

import com.nicholas.vo.parms.NearDataList;
import com.nicholas.vo.redis.DataPosition;

import java.util.List;

public interface DataServiceFromRedis {

    List<DataPosition> nearDataList(NearDataList nearDataList);

}
