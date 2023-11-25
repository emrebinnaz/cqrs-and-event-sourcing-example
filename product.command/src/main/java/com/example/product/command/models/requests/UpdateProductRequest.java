package com.example.product.command.models.requests;

import java.math.BigDecimal;

import com.example.product.command.models.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public final class UpdateProductRequest {
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

    @JsonProperty("discountRatio")
    @Min(0)
    @Max(100)
    private final Double discountRatio;

    
    @JsonCreator
    public UpdateProductRequest(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("status") ProductStatus status,
            @JsonProperty("numberInStock") Integer numberInStock, @JsonProperty("price") BigDecimal price,
            @JsonProperty("discountRatio") Double discountRatio) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.numberInStock = numberInStock;
        this.price = price;
        this.discountRatio = discountRatio;
    }

}
