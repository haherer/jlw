package com.nicholas.vo;

public enum ErrorCode {

    REGISTER_ERROR(101,"注册失败"),
    REGISTER_ACCOUNT_REPEAT(102,"账号已存在"),
    REGISTER_PHONE_REPEAT(103,"手机号已存在"),
    ACCOUNT_NULL(104,"账号不能为空"),
    PASSWORD_NULL(105,"密码不能为空"),
    PHONE_NULL(106,"手机号不能为空"),
    ACCOUNT_CHECK_ERROR(107,"账号由字母数字下划线组成且开头必须是字母，不能超过16位"),
    PASSWORD_CHECK_ERROR(108,"密码由字母或数字构成，不能超过6~16位"),
    PHONE_CHECK_ERROR(109,"手机号不符合要求"),
    LOGIN_ERROR(110,"账号或密码错误"),
    LOGIN_FAIL(111,"登录失败"),
    TOKEN_FAIL(112,"token，请重新登录"),
    ACCOUNT_CLOSE(113,"账号被冻结"),
    DATA_NULL(114,"无数据"),
    RELEASE_NULL(114,"经纬度、poi、发布内容不可为空"),
    RELEASE_FAIL(115,"发布失败");



    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ErrorCode() {
    }
}
