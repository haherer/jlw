package com.nicholas.vo.redis;

import lombok.Builder;

import java.util.Date;

@Builder
public class DataPosition {

    private String dataId;

    private String cityCode;

    private double lng;

    private double lat;

    private double km;

    private Long uid;

    private String nickName;

    private Date creationTime;

    private String poi;

    private String content;

    private String imgUrl;

    private String videoUrl;

    private Long hotValue;

    private Double accuracy;

    private Long trueSum;

    private Long falseSum;

    private Long commentSum;

    @Override
    public String toString() {
        return "DataPosition{" +
                "dataId='" + dataId + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", km=" + km +
                ", uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", creationTime=" + creationTime +
                ", poi='" + poi + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", hotValue=" + hotValue +
                ", accuracy=" + accuracy +
                ", trueSum=" + trueSum +
                ", falseSum=" + falseSum +
                ", commentSum=" + commentSum +
                '}';
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
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

    public DataPosition(String dataId, String cityCode, double lng, double lat, double km, Long uid, String nickName, Date creationTime, String poi, String content, String imgUrl, String videoUrl, Long hotValue, Double accuracy, Long trueSum, Long falseSum, Long commentSum) {
        this.dataId = dataId;
        this.cityCode = cityCode;
        this.lng = lng;
        this.lat = lat;
        this.km = km;
        this.uid = uid;
        this.nickName = nickName;
        this.creationTime = creationTime;
        this.poi = poi;
        this.content = content;
        this.imgUrl = imgUrl;
        this.videoUrl = videoUrl;
        this.hotValue = hotValue;
        this.accuracy = accuracy;
        this.trueSum = trueSum;
        this.falseSum = falseSum;
        this.commentSum = commentSum;
    }

    public DataPosition() {
    }
}
