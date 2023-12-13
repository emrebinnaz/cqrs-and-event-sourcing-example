package com.example.product.command.domain.exception;

import org.springframework.http.HttpStatus;

import com.example.product.command.common.exception.BaseException;

public class AggregateNotFoundException extends BaseException {
    public AggregateNotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
