package com.exampl.communt.exception;

public enum  AcmeExceptionCode implements IAcmeExceptionCode {

    Question_ERROR_MESSAGE(20001,"信息不存在，请稍后再试"),
    COMMENT_ERROR_MESSAGE(20002,"parentId 不存在"),
    USER_LOGIN_ERROR_CODE(20003,"用户信息未登录");
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

    AcmeExceptionCode(final Integer code,final String mssage) {
        this.mssage = mssage;
        this.code = code;
    }
}
