package com.example.product.command.commands;

import java.math.BigDecimal;
import java.util.Date;

import com.example.product.command.models.enums.ProductStatus;
import com.example.product.command.models.requests.UpdateProductRequest;

import lombok.Getter;

@Getter
public final class ProductUpdatedCommand extends BaseCommand{

    private final String name;
    private final String description;
    private final ProductStatus status;
    private final Date updateDate;
    private final Integer numberInStock;
    private final BigDecimal price;
    private final Double discountRatio;

    public ProductUpdatedCommand(UpdateProductRequest req, String id) {
        super(id);
        this.name = req.getName();
        this.description = req.getDescription();
        this.status = req.getStatus();
        this.updateDate = new Date();
        this.numberInStock = req.getNumberInStock();
        this.price = req.getPrice();
        this.discountRatio = req.getDiscountRatio();
    }
    
}
