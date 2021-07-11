package com.desafio.zup.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public EntityNotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;

    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = HttpStatus.NOT_FOUND;

    }
}
