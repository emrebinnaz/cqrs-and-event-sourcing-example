package com.example.product.command.exception;

import org.springframework.http.HttpStatus;

public class ProductIsAlreadyDeletedException extends BaseException {


    public ProductIsAlreadyDeletedException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }
    
}
