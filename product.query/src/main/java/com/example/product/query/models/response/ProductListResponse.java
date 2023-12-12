package com.example.product.query.models.response;

import java.util.List;

import com.example.product.query.models.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductListResponse extends BaseResponse{
    @JsonProperty("products")
    private List<ProductDto> products;

    @JsonCreator
    public ProductListResponse(@JsonProperty("message") String message,
                               @JsonProperty("products") List<ProductDto> products) {
        super(message);
        this.products = products;
    }
    
}
