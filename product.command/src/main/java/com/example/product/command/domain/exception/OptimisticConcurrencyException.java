package com.example.product.command.domain.exception;

import org.springframework.http.HttpStatus;

import com.example.product.command.common.exception.BaseException;

public class OptimisticConcurrencyException extends BaseException {
    public OptimisticConcurrencyException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
