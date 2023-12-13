package com.example.product.command.application.commands;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.example.product.command.common.enums.ProductStatus;
import com.example.product.command.presentation.requests.AddProductRequest;

import lombok.Getter;
@Getter
public final class ProductAddedCommand extends BaseCommand {

    private final String name;
    private final String description;
    private final ProductStatus status;
    private final Date creationDate = new Date();
    private final Integer numberInStock;
    private final BigDecimal price;
    private final Double discountRatio = 0.0;

    public ProductAddedCommand(AddProductRequest request) {
        super(UUID.randomUUID().toString());
        this.name = request.getName();
        this.description = request.getDescription();
        this.status = request.getStatus();
        this.numberInStock = request.getNumberInStock();
        this.price = request.getPrice();
    }
}
