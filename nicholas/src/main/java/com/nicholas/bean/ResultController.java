package com.nicholas.bean;



import org.springframework.stereotype.Component;

//返回对象
@Component
public class ResultController {

    private String code;
    private String msg;

    public ResultController(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultController() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

