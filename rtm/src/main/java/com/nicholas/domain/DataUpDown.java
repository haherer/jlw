package com.nicholas.domain;

import java.io.Serializable;
import java.util.Date;

public class DataUpDown implements Serializable {

    private Long id;

    private Integer userUid;

    private Integer upDown;

    private String dataUid;

    private Date time;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserUid() {
        return userUid;
    }

    public void setUserUid(Integer userUid) {
        this.userUid = userUid;
    }

    public Integer getUpDown() {
        return upDown;
    }

    public void setUpDown(Integer upDown) {
        this.upDown = upDown;
    }

    public String getDataUid() {
        return dataUid;
    }

    public void setDataUid(String dataUid) {
        this.dataUid = dataUid == null ? null : dataUid.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}