package com.example.product.command.exception;

import org.springframework.http.HttpStatus;

public class ProductIsNotAvailableException extends BaseException{

    public ProductIsNotAvailableException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
        //TODO Auto-generated constructor stub
    }
    
}
