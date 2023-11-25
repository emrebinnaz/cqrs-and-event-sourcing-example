package com.example.product.command.commands;

import com.example.product.command.models.enums.ProductStatus;
import com.example.product.command.models.requests.ProductStatusChangedRequest;

import lombok.Getter;

@Getter
public final class ProductStatusChangedCommand extends BaseCommand{
    private final  ProductStatus status;
    public ProductStatusChangedCommand(String id, ProductStatusChangedRequest request) {
        super(id);
        this.status = request.getStatus();
    }
}
