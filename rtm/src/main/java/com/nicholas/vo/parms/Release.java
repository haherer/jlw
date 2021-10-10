package com.nicholas.vo.parms;


public class Release {
    private Double longitude;
    private Double latitude;
    private String poi;
    private String content;
    private String imgUrl;
    private String videoUrl;

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

    public Release(Double longitude, Double latitude, String poi, String content, String imgUrl, String videoUrl) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.poi = poi;
        this.content = content;
        this.imgUrl = imgUrl;
        this.videoUrl = videoUrl;
    }

    public Release() {
    }
}
