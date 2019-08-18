package com.exampl.communt.mode;

import java.io.Serializable;

public class PublishMode implements Serializable {

    private Integer id;
    private String title;
    private String describeText;
    private String label;
    private String creatId;//创建人的id
    private int replyCount;//回复次数
    private int viewCount;//游览次数
    private long gmtCreate;
    private long gmtModified;

    public String getDescribeText() {
        return describeText;
    }

    public void setDescribeText(String describeText) {
        this.describeText = describeText;
    }

    public String getCreatId() {
        return this.creatId;
    }

    public void setCreatId(final String creatId) {
        this.creatId = creatId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }


    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public long getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(final long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public long getGmtModified() {
        return this.gmtModified;
    }

    public void setGmtModified(final long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    public void setReplyCount(final int replyCount) {
        this.replyCount = replyCount;
    }

    public int getViewCount() {
        return this.viewCount;
    }

    public void setViewCount(final int viewCount) {
        this.viewCount = viewCount;
    }
}
