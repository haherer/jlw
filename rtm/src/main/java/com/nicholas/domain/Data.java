package com.nicholas.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

public class Data implements Serializable {

    private Integer id;//自增ID

    private Long uid;//用户UID

    private Date creationTime;//创建时间

    private Double longitude;//经度

    private Double latitude;//纬度

    private String poi;//经纬度对应的建筑地址

    private String content;//发布内容

    private String imgUrl;//图片路径

    private String videoUrl;//视频路径

    private Integer state;//状态，0可见，1屏蔽

    private Integer sort;//排序，越大排序越前

    private Long hotValue;//热度值

    private Double accuracy;//可信度

    private String dataUid;//数据编号

    private Long trueSum;

    private Long falseSum;

    private Long commentSum;

    private String cityId;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Long getTrueSum() {
        return trueSum;
    }

    public void setTrueSum(Long trueSum) {
        this.trueSum = trueSum;
    }

    public Long getFalseSum() {
        return falseSum;
    }

    public void setFalseSum(Long falseSum) {
        this.falseSum = falseSum;
    }

    public Long getCommentSum() {
        return commentSum;
    }

    public void setCommentSum(Long commentSum) {
        this.commentSum = commentSum;
    }

    private static final long serialVersionUID = 1L;

    public String getDataUid() {
        return dataUid;
    }

    public void setDataUid(String dataUid) {
        this.dataUid = dataUid;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi == null ? null : poi.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getHotValue() {
        return hotValue;
    }

    public void setHotValue(Long hotValue) {
        this.hotValue = hotValue;
    }

}