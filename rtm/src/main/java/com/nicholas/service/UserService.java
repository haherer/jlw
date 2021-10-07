package com.nicholas.service;

import com.nicholas.domain.User;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.UserReg;

public interface UserService {

    Result register(UserReg user);

    Boolean isAccount(String account);

    Boolean isPhone(Integer phone);

}
