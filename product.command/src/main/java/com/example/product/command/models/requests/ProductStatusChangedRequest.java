package com.example.product.command.models.requests;

import com.example.product.command.models.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public final class ProductStatusChangedRequest {
    
    @JsonProperty("status")
    @NotNull
    private final ProductStatus status;

    @JsonCreator
    public ProductStatusChangedRequest(@JsonProperty("status") ProductStatus status) {
        this.status = status;
    }
}
