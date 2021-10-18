package com.nicholas.vo.Enum;

import java.util.Date;

public enum UserField {

    ID("id"),
    UID("uid"),
    ACCOUNT("account"),
    PASSWORD("password"),
    REGISTER_DATE("registerDate"),
    LAST_LONGIN_DATE("lastloginDate"),
    ACCOUNT_STATUS("accountStatus"),
    PHONE_NUMBER("phoneNumber"),
    USER_LEVEL("userLevel"),
    LEVEL_VALUE("levelValue"),
    NAME("name"),
    NICK_NAME("nickName");

    private String filed;

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    UserField(String filed) {
        this.filed = filed;
    }

    UserField() {
    }
}
