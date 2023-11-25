package com.example.product.command.models.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {

    @JsonProperty("message")
    private String message;

    @JsonCreator
    public BaseResponse(@JsonProperty("message") String message) {
        this.message = message;
    }
}
