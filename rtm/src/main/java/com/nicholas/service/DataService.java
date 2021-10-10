package com.nicholas.service;

import com.nicholas.vo.UserQueryVo;
import com.nicholas.vo.parms.Release;

public interface DataService {
    Integer addData(Release release, UserQueryVo userQueryVo);
}
