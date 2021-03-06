package com.nicholas.vo.parms;

public class UserReg {

    private String account;

    private String password;

    private String phone;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserReg(String account, String password, String phone) {
        this.account = account;
        this.password = password;
        this.phone = phone;
    }

    public UserReg() {
    }
}
