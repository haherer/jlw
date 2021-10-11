package com.nicholas.domain;

import java.io.Serializable;

public class DataCount implements Serializable {

    private Long id;

    private Integer dataId;

    private Long trueSum;

    private Long falseSum;

    private Long commentSum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
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
}