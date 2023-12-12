package com.example.product.query.exceptionhandling;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends BaseException{

    public ProductNotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
    
}
