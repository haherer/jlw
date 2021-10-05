package com.nicholas.bean;

import org.springframework.stereotype.Component;

@Component
public class ResultControllerObj {
    private String code;
    private String msg;
    private Object data;

    public ResultControllerObj(String code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

    public ResultControllerObj() {
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

    public Object getObj() {
        return data;
    }

    public void setObj(Object obj) {
        this.data = obj;
    }
}
