package com.example.product.query.exceptionhandling;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    protected HttpStatus httpStatus;
    public BaseException(String message) {
        super(message);
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
