package com.exampl.communt.exception;

public class AcmeException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public AcmeException(AcmeExceptionCode acmeExceptionCode) {
        this.message = acmeExceptionCode.getMessage();
    }
}
