package com.example.product.command.exception;

import org.springframework.http.HttpStatus;

public class AggregateNotFoundException extends BaseException {
    public AggregateNotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
