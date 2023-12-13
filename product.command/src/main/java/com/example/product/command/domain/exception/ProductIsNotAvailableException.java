package com.example.product.command.domain.exception;

import org.springframework.http.HttpStatus;

import com.example.product.command.common.exception.BaseException;

public class ProductIsNotAvailableException extends BaseException{

    public ProductIsNotAvailableException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
        //TODO Auto-generated constructor stub
    }
    
}
