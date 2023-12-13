package com.example.product.query.application.exceptions;

import org.springframework.http.HttpStatus;

import com.example.product.query.common.exception.BaseException;

public class ProductNotFoundException extends BaseException{

    public ProductNotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
    
}
