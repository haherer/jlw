package com.nicholas.service.impl;

import com.nicholas.domain.User;
import com.nicholas.mapper.UserMapper;
import com.nicholas.service.UserService;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.UserReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User userDao;

    @Override
    public Result register(UserReg user){
        userDao.setAccount(user.getAccount());
        //设置一个随机UID
    }


    @Override
    public Boolean isAccount(String account) {
        User user = userMapper.selectByPrimaryAccount(account);
        if (null == user){
            return false;
        }
        return true;
    }

    @Override
    public Boolean isPhone(Integer phone) {
        User user = userMapper.selectByPrimaryPhone(phone);
        if (null == user){
            return false;
        }
        return true;
    }
}
