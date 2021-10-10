package com.nicholas.service.impl;

import com.nicholas.bean.MyBCrypt;
import com.nicholas.domain.User;
import com.nicholas.mapper.UserMapper;
import com.nicholas.service.UserService;
import com.nicholas.vo.ErrorCode;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.UserLog;
import com.nicholas.vo.parms.UserReg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MyBCrypt myBCrypt;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User userDao;

    @Override
    public Result register(UserReg user){
        //赋值
        userDao.setAccount(user.getAccount());
        userDao.setUid(new Long(System.currentTimeMillis()).intValue());//根据当前时间生成一个UID
        userDao.setPassword(myBCrypt.encode(user.getPassword()));
        userDao.setRegisterDate(new Date());
        userDao.setPhoneNumber(user.getPhone());
        if (userMapper.insert(userDao) > 0){
            return Result.success(null);
        }
        return Result.fail(ErrorCode.REGISTER_ERROR.getCode(), ErrorCode.REGISTER_ERROR.getMsg());
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
    public Boolean isPhone(String phone) {
        User user = userMapper.selectByPrimaryPhone(phone);
        if (null == user){
            return false;
        }
        return true;
    }

    public User findAccount(String account){
        return userMapper.selectByPrimaryAccount(account);
    }

    @Override
    public User findUid(Integer uid) {
        if (null == uid){
            return null;
        }
        return userMapper.selectByPrimaryUid(uid);
    }

    @Override
    public User login(UserLog userLog) {
        User user = findAccount(userLog.getAccount());

        if (!myBCrypt.matches(userLog.getPassword(),user.getPassword())) {
            log.info("密码校验错误，登录失败");
            return null;
        }
        log.info("密码校验成功");
        user.setLastloginDate(new Date());
        if (userMapper.updateByPrimaryKeySelective(user) > 0){
            return user;
        }
        return null;
    }
}
