package com.nicholas.vo.Enum;

public enum RedisKey {

    PASSWORD_KEY("@pwd@"),
    TOKEN_KEY("@tok@"),
    PHONE_KEY("@pho@"),
    DATA_UP_DOWN("@upDown");


    private String key;

    RedisKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    RedisKey() {
    }
}
