package com.exampl.communt.enums;

/**
 * 定义评论，回复 标识
 */
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


    public static boolean isEmpty(Integer type) {
        for (CommentEnums commentEnums: CommentEnums.values()) {
            if (commentEnums.getType()==type){
                return true;
            }
        }
        return false;
    }
}
