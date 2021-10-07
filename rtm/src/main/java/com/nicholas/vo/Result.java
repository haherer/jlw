package com.nicholas.vo;

public class Result {

    private boolean success;

    private int code;

    private String msg;

    private Object obj;

    public static Result success(Object obj){
        return  new Result(true , 200 ,"success" , obj);
    }

    public static Result fail(int code , String msg){
        return new Result(false , code , msg , null);
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Result(boolean success, int code, String msg, Object obj) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public Result() {
    }


}
