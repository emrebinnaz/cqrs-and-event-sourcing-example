package com.example.product.command.exception;

import org.springframework.http.HttpStatus;

public class OptimisticConcurrencyException extends BaseException {
    public OptimisticConcurrencyException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
