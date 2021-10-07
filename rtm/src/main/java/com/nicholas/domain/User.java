package com.nicholas.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class User implements Serializable {

    private Integer id;//自增ID

    private Integer uid;//用户编号

    private String account;//登录账号

    private String password;//登录密码

    private Date registerDate;//注册时间

    private Date lastloginDate;//最后登录时间

    private Integer accountStatus = 0;//账号状态，0开启，1冻结

    private Integer phoneNumber;//手机号

    private Integer userLevel = 1;//用户级别

    private Long levelValue = 0L;//经验值

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastloginDate() {
        return lastloginDate;
    }

    public void setLastloginDate(Date lastloginDate) {
        this.lastloginDate = lastloginDate;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Long getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(Long levelValue) {
        this.levelValue = levelValue;
    }
}