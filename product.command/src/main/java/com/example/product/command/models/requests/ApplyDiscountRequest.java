package com.example.product.command.models.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;


@Getter
public final class ApplyDiscountRequest {

    @JsonProperty("discountRatio")
    @Min(0)
    @Max(100)
    private final Double discountRatio;
    
    @JsonCreator
    public ApplyDiscountRequest(@JsonProperty("discountRatio") Double discountRatio) {
        this.discountRatio = discountRatio;
    }

}
