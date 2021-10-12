package com.nicholas.vo.parms;

import java.util.Date;

public class CommentRelease {

    private String dataUid;

    private Long uid;

    private String content;


    @Override
    public String toString() {
        return "CommentRelease{" +
                "dataUid='" + dataUid + '\'' +
                ", uid=" + uid +
                ", content='" + content + '\'' + '}';
    }

    public String getDataUid() {
        return dataUid;
    }

    public void setDataUid(String dataUid) {
        this.dataUid = dataUid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentRelease(String dataUid, Long uid, String content, Date creationTime) {
        this.dataUid = dataUid;
        this.uid = uid;
        this.content = content;
    }

    public CommentRelease() {
    }
}
