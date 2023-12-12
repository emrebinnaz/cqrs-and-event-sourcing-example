package com.example.product.query.models.response;

import java.util.List;

import com.example.product.query.models.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonCreator;

public final class FindAllProductsBetweenSpecificDatesResponse extends ProductListResponse {

    @JsonCreator
    public FindAllProductsBetweenSpecificDatesResponse(String message, List<ProductDto> products) {
        super(message, products);
    }
    
}
