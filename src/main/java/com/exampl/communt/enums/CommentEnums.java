package com.exampl.communt.enums;

public enum  CommentEnums {

    QUESTION(1),

    COMMIT(2);

    private Integer type;

    public Integer getType() {
        return this.type;
    }

    CommentEnums(Integer type) {
        this.type = type;
    }
}
