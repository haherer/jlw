package com.nicholas.vo;

import com.nicholas.domain.Level;



public class UserQueryVo {

    private Integer uid;
    private String account;
    private String phone;
    private Level userLevel;
    private Long levelValue;
    private String name;
    private String nickName;

    public UserQueryVo(Integer uid, String account, String phone, Level userLevel, Long levelValue, String name, String nickName) {
        this.uid = uid;
        this.account = account;
        this.phone = phone;
        this.userLevel = userLevel;
        this.levelValue = levelValue;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserQueryVo{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", userLevel=" + userLevel +
                ", levelValue=" + levelValue +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserQueryVo() {
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
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Level getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Level userLevel) {
        this.userLevel = userLevel;
    }

    public Long getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(Long levelValue) {
        this.levelValue = levelValue;
    }

}
