package com.example.product.command.exception;

import org.springframework.http.HttpStatus;

public class ProdcutIsNotAvailableException extends BaseException{

    public ProdcutIsNotAvailableException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
        //TODO Auto-generated constructor stub
    }
    
}
