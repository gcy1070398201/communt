package com.exampl.communt.dto;

public class CommentDto {
    private Integer parentId;
    private String content;
    private Integer type;

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(final Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(final Integer type) {
        this.type = type;
    }
}
