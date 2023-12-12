package com.example.product.query.models.response;

import java.util.List;

import com.example.product.query.models.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class FindProductsByNameResponse extends ProductListResponse {

    @JsonCreator
    public FindProductsByNameResponse(@JsonProperty("message") String message,
                                      @JsonProperty("products") List<ProductDto> products) {
        super(message, products);
    }
}
