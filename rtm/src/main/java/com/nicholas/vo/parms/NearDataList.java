package com.nicholas.vo.parms;

public class NearDataList {

    private String cityId ;
    private Double lng ;
    private Double lat ;
    private Double near;
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public NearDataList() {
    }

    @Override
    public String toString() {
        return "NearDataList{" +
                "cityId='" + cityId + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", near=" + near +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getNear() {
        return near;
    }

    public void setNear(Double near) {
        this.near = near;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public NearDataList(String cityId, Double lng, Double lat, Double near, Integer pageNum, Integer pageSize) {
        this.cityId = cityId;
        this.lng = lng;
        this.lat = lat;
        this.near = near;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
