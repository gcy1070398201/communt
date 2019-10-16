package com.exampl.communt.exception;

public enum  AcmeExceptionCode implements IAcmeExceptionCode {

    Question_ERROR_MESSAGE(20001,"信息不存在，请稍后再试"),
    COMMENT_ERROR_MESSAGE(20002,"parentId 不存在"),
    COMMENT_ERROR_CONTENT(20002,"评论内容不能为空"),
    COMMENT_ERROR_TYPE(20004,"评论信息不存在"),
    COMMENT_NOT_FIND(20006,"回复信息不存在"),
    USER_LOGIN_ERROR_CODE(20003,"用户信息未登录"),
    USER_NOT_FIND_CODE(20003,"用户信息未查到"),
    ACME_EXCEPTION_CODE(40003,"你的访问路径不存在"),
    SYSTEM_ERROR_CODE(90000,"服务器冒烟了，请稍后再试");
    private String mssage;
    private Integer code;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return mssage;
    }

    public void setMssage(final String mssage) {
        this.mssage = mssage;
    }

    AcmeExceptionCode(final Integer code, final String mssage) {
        this.mssage = mssage;
        this.code = code;

    }
}
