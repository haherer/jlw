package com.nicholas.service.impl;

import com.nicholas.bean.MyBCrypt;
import com.nicholas.domain.User;
import com.nicholas.mapper.UserMapper;
import com.nicholas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User user;

    @Autowired
    private MyBCrypt myBCrypt;

    @Override
    public Integer addUser(String account ,String password) {
        if (userMapper.selectByAccount(account) != null){
            return 0;//用户名已存在
        }else {
            long registerDate = System.currentTimeMillis();//获取系统时间
            Integer userUid = new Long(registerDate).intValue();

            user.setUid(userUid);//设置UID
            user.setRegisterDate(new Date());//设置注册时间
            user.setAccount(account);//设置账号
            user.setPassword(myBCrypt.encode(password));//密码加密

            if (userMapper.insert(user) > 0){
                return 1;//注册成功
            }
            return -1;//注册失败，未知原因
        }
   }

    @Override
    public Integer login(String account, String password) {
        User user = userMapper.selectByAccount(account);
        if (null == user){
            return 1;//用户名不存在
        }
        String srcPassWord = user.getPassword();
        if (myBCrypt.matches(password,srcPassWord)){
            return 0;//用户名密码正确
        }
        return -1;//密码错误
    }

    @Override
    public User query(String account) {
        User user = userMapper.selectByAccount(account);
        if (null == user){
            return null;//用户名不存在
        }
        return user;
    }
}
