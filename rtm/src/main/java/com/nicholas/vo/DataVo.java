package com.nicholas.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DataVo {
    private Integer uid;
    private Date creationTime;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String poi;
    private String content;
    private String imgUrl;
    private String videoUrl;
    private Long hotValue;
    private String dataUid;
    private Double accuracy;

    public Double getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        return "DataVo{" +
                "uid=" + uid +
                ", creationTime=" + creationTime +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", poi='" + poi + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", hotValue=" + hotValue +
                ", dataUid='" + dataUid + '\'' +
                ", accuracy=" + accuracy +
                '}';
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public DataVo(Integer uid, Date creationTime, BigDecimal longitude, BigDecimal latitude, String poi, String content, String imgUrl, String videoUrl, Long hotValue, String dataUid, Double accuracy) {
        this.uid = uid;
        this.creationTime = creationTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.poi = poi;
        this.content = content;
        this.imgUrl = imgUrl;
        this.videoUrl = videoUrl;
        this.hotValue = hotValue;
        this.dataUid = dataUid;
        this.accuracy = accuracy;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getHotValue() {
        return hotValue;
    }

    public void setHotValue(Long hotValue) {
        this.hotValue = hotValue;
    }

    public String getDataUid() {
        return dataUid;
    }

    public void setDataUid(String comment) {
        this.dataUid = comment;
    }


    public DataVo() {
    }
}