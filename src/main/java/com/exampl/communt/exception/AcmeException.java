package com.exampl.communt.exception;

/**
 * 全局异常类
 */
public class AcmeException extends RuntimeException {

    //异常信息
    private String message;
    //异常状态码
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return this.code;
    }

    public AcmeException(AcmeExceptionCode acmeExceptionCode) {
        this.message = acmeExceptionCode.getMessage();
        this.code=acmeExceptionCode.getCode();
    }
}
