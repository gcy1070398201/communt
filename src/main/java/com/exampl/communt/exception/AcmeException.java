package com.exampl.communt.exception;

public class AcmeException extends RuntimeException {
    private String message;
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
