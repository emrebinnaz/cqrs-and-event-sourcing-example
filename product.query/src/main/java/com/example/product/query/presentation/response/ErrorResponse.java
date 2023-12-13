package com.example.product.query.presentation.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse extends BaseResponse{

    @JsonCreator
    public ErrorResponse(@JsonProperty("message") String message) {
        super(message);
    }
}