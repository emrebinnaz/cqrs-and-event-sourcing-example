package com.example.product.query.presentation.response;

import com.example.product.query.application.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse extends BaseResponse{

    @JsonProperty("product")
    private ProductDto product;

    @JsonCreator
    public ProductResponse(@JsonProperty("message") String message,
                                   @JsonProperty("product") ProductDto product) {
        super(message);
        this.product = product;
    }
}
