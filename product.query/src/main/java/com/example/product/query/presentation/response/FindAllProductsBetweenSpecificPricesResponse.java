package com.example.product.query.presentation.response;

import java.util.List;

import com.example.product.query.application.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;

public final class FindAllProductsBetweenSpecificPricesResponse extends ProductListResponse {

    @JsonCreator
    public FindAllProductsBetweenSpecificPricesResponse(String message, List<ProductDto> products) {
        super(message, products);
    }
    
}
