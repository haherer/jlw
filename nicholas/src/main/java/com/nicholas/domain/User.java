package com.nicholas.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class User implements Serializable {

    private Integer id;

    private Integer uid;

    private String account;

    private String password;

    private Date registerDate;

    private Date lastloginDate;

    private Integer accountStatus = 0;

    private Integer phoneNumber;

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
}