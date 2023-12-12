package com.example.product.query.models.response;

import java.util.List;

import com.example.product.query.models.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;

public final class FindAllProductsBetweenSpecificPricesResponse extends ProductListResponse {

    @JsonCreator
    public FindAllProductsBetweenSpecificPricesResponse(String message, List<ProductDto> products) {
        super(message, products);
    }
    
}
