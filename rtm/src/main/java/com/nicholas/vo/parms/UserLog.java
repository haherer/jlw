package com.nicholas.vo.parms;

public class UserLog {

    private String account;

    private String password;

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

    public UserLog(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public UserLog() {
    }
}
