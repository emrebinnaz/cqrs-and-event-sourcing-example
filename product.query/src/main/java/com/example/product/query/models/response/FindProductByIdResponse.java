package com.example.product.query.models.response;

import com.example.product.query.models.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;
public final class FindProductByIdResponse extends ProductResponse {

    @JsonCreator
    public FindProductByIdResponse(String message, ProductDto product) {
        super(message, product);
    }
}
