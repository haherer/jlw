package com.nicholas.domain;

import java.io.Serializable;

public class Level implements Serializable {

    private Integer id;//自增ID

    private Integer levelId;//等级

    private String levelName;//等级名称

    private Long value;//经验值

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", value=" + value +
                '}';
    }
}