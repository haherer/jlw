package com.nicholas.service;


import com.nicholas.domain.User;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.UserLog;
import com.nicholas.vo.parms.UserReg;

public interface UserService {

    Result register(UserReg user);

    Boolean isAccount(String account);

    Boolean isPhone(String phone);

//    User findAccount(String account);
//
//    User findUid(Integer uid);

    User login(UserLog userLog);
}
