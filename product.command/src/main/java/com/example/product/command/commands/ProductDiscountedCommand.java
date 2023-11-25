package com.example.product.command.commands;

import lombok.Getter;

@Getter
public final class ProductDiscountedCommand extends BaseCommand{
    private final Double discountRatio;
    public ProductDiscountedCommand(String id, Double discountRatio) {
        super(id);
        this.discountRatio = discountRatio;
    }
    
}
