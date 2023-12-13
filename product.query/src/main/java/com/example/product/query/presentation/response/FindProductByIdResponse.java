package com.example.product.query.presentation.response;

import com.example.product.query.application.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;
public final class FindProductByIdResponse extends ProductResponse {

    @JsonCreator
    public FindProductByIdResponse(String message, ProductDto product) {
        super(message, product);
    }
}
