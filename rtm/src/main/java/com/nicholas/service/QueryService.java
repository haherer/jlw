package com.nicholas.service;


import com.nicholas.domain.Level;
import com.nicholas.vo.DataVo;
import com.nicholas.vo.UserQueryVo;

import java.util.List;

public interface QueryService {

    UserQueryVo queryUserByToken(String token);

    Level queryLevelByLevelId(Integer levelId);

    List<DataVo> queryAllData(Integer pageNum , Integer pageSize);
}
