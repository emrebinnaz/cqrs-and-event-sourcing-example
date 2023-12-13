package com.example.product.command.domain.exception;

import org.springframework.http.HttpStatus;

import com.example.product.command.common.exception.BaseException;

public class ProductIsAlreadyDeletedException extends BaseException {


    public ProductIsAlreadyDeletedException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
    
}
