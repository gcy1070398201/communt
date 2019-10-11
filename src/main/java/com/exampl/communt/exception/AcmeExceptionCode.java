package com.exampl.communt.exception;

public enum  AcmeExceptionCode implements IAcmeExceptionCode {

    Question_ERROR_MESSAGE("信息不存在，请稍后再试");

    private String mssage;

    @Override
    public String getMessage() {
        return mssage;
    }

    AcmeExceptionCode(final String mssage) {
        this.mssage = mssage;
    }
}
