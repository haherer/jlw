package com.nicholas.service.impl;

import com.nicholas.bean.MyBCrypt;
import com.nicholas.domain.User;
import com.nicholas.mapper.UserMapper;
import com.nicholas.service.UserService;
import com.nicholas.utils.RedisUtils;
import com.nicholas.vo.Enum.ErrorCode;
import com.nicholas.vo.Enum.RedisKey;
import com.nicholas.vo.Enum.UserField;
import com.nicholas.vo.Result;
import com.nicholas.vo.parms.UserLog;
import com.nicholas.vo.parms.UserReg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MyBCrypt myBCrypt;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils  redisUtils;

    @Override
    public Result register(UserReg user){

        User userDao = new User();
        //赋值
        userDao.setAccount(user.getAccount());
        userDao.setUid(System.currentTimeMillis());//根据当前时间生成一个UID
        userDao.setPassword(myBCrypt.encode(user.getPassword()));
        userDao.setRegisterDate(new Date());
        userDao.setPhoneNumber(user.getPhone());

        if (userMapper.insert(userDao) > 0){
            log.info("表注册成功，同步用户数据放入缓存");
            HashMap<String, Object> userMap = new HashMap<>();
            userMap.put(UserField.UID.getFiled(), userDao.getUid());
            userMap.put(UserField.REGISTER_DATE.getFiled(), userDao.getRegisterDate());
            userMap.put(UserField.PHONE_NUMBER.getFiled(), userDao.getPhoneNumber());
            userMap.put(UserField.ACCOUNT_STATUS.getFiled(), "0");
            userMap.put(UserField.USER_LEVEL.getFiled(), "1");
            userMap.put(UserField.LEVEL_VALUE.getFiled(), "0");

            redisUtils.hmset(userDao.getAccount(), userMap);
            log.info("表注册成功，缓存创建用户数据");

            redisUtils.sSet(RedisKey.PHONE_KEY.getKey(), userDao.getPhoneNumber());
            log.info("表注册成功，同步手机号进缓存");

            redisUtils.hset(RedisKey.PASSWORD_KEY.getKey(), userDao.getAccount() ,userDao.getPassword());
            log.info("表注册成功，加密后密码进缓存");
            return Result.success(null);
        }
        return Result.fail(ErrorCode.REGISTER_ERROR.getCode(), ErrorCode.REGISTER_ERROR.getMsg());
    }


    @Override
    public Boolean isAccount(String account) {
        if(!redisUtils.hasKey(account)){
            log.info("缓存里无账号对应数据");
            if (null == userMapper.selectByPrimaryAccount(account)){
                log.info("数据库里无账号对应数据");
                return false;
            }
            log.info("数据库里找到账号对应数据");
            return true;
        }
        log.info("缓存里找到账号对应数据");
        return true;
    }

    @Override
    public Boolean isPhone(String phone) {
        if (!redisUtils.sHasKey(RedisKey.PHONE_KEY.getKey(), phone)){
            log.info("缓存里无手机号对应数据");
            if (null == userMapper.selectByPrimaryPhone(phone)){
                log.info("数据库里无手机号对应数据");
                return false;
            }
            log.info("数据库里找到手机号");
            return true;
        }
        log.info("缓存里找到手机号");
        return true;
    }

//    public User findAccount(String account){
//        Map<Object, Object> user = redisUtils.hmget(account);
//        log.info("缓存对象：" + user);
//        if (null == user){
//            log.info("缓存里未找到账号，前往数据库寻找");
//            return userMapper.selectByPrimaryAccount(account);
//        }
//        log.info("缓存里找到账号");
//        return null;
//    }

//    @Override
//    public User findUid(Integer uid) {
//        if (null == uid){
//            return null;
//        }
//        return userMapper.selectByPrimaryUid(uid);
//    }

    @Override
    public User login(UserLog userLog) {
//        User user = findAccount(userLog.getAccount());
        String passWord = (String) redisUtils.hget(RedisKey.PASSWORD_KEY.getKey(), userLog.getAccount());
        if (!myBCrypt.matches(userLog.getPassword(),passWord)) {
            log.info("密码校验错误，登录失败");
            return null;
        }
        log.info("密码校验成功");

        Long uid = (Long) redisUtils.hget(userLog.getAccount(), UserField.UID.getFiled());

        User user = new User();
        user.setUid(uid);
        user.setLastloginDate(new Date());
        user.setAccount(userLog.getAccount());
        Object sta = redisUtils.hget(userLog.getAccount(), UserField.ACCOUNT_STATUS.getFiled());
        Integer i = Integer.parseInt((String) sta);//String解析Integer
        user.setAccountStatus(i);

        log.info("数据库更新最后登录时间");
        if (userMapper.updateByPrimaryKeySelective(user) <= 0){
            log.error("数据库更新最后登录时间失败");
            return null;
        }

        redisUtils.hset(userLog.getAccount() , UserField.LAST_LONGIN_DATE.getFiled() , user.getLastloginDate().toString());
        log.info("缓存更新最后登录时间");
        return user;
    }
}
