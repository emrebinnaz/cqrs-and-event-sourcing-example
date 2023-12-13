package com.example.product.command.presentation.requests;

import java.math.BigDecimal;

import com.example.product.command.common.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public final class AddProductRequest {

    @JsonProperty("name")
    @NotBlank
    private final String name;
   
    @JsonProperty("description")
    @NotBlank
    private final String description;

    @JsonProperty("status")
    @NotNull
    private final ProductStatus status;

    @JsonProperty("numberInStock")
    @Min(1)
    @Positive
    private final Integer numberInStock;

    @JsonProperty("price")
    @Positive
    private final BigDecimal price;
    
    @JsonCreator
    public AddProductRequest(@JsonProperty("name") String name, @JsonProperty("description") String description, 
                              @JsonProperty("status") ProductStatus status, @JsonProperty("numberInStock") Integer numberInStock,
                              @JsonProperty("price") BigDecimal price) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.numberInStock = numberInStock;
        this.price = price;
    }

}
