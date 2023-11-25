package com.example.product.command.models.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public final class ProductStockChangedRequest {
    
    @Positive
    @JsonProperty("stock")
    private final Integer stock;

    @JsonCreator
    public ProductStockChangedRequest(@JsonProperty("stock") Integer stock) {
        this.stock = stock;
    }
}
