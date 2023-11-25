package com.example.product.command.commands;

import com.example.product.command.models.requests.ProductStockChangedRequest;

import lombok.Getter;

@Getter
public final class ProductStockChangedCommand extends BaseCommand{
    private Integer numberInStock;
    public ProductStockChangedCommand(String id, ProductStockChangedRequest request) {
        super(id);
        this.numberInStock = request.getStock();
    }
    
}
