package com.example.product.command.events;

import java.math.BigDecimal;
import java.util.Date;

import com.example.product.command.commands.ProductAddedCommand;
import com.example.product.command.models.enums.ProductStatus;

import lombok.Getter;

@Getter
public final class ProductAddedEvent extends BaseEvent{
    private String name;
    private String description;
    private String status;
    private Date creationDate;
    private Integer numberInStock;
    private BigDecimal price;
    private Double discountRatio;

    private ProductAddedEvent(ProductAddedCommand command) {
        super(command.getId());
        this.creationDate = command.getCreationDate();
        this.description = command.getDescription();
        this.name = command.getName();
        this.status = command.getStatus().name();
        this.numberInStock = command.getNumberInStock();
        this.discountRatio = command.getDiscountRatio();
        this.price = command.getPrice();
    }
    
    public static ProductAddedEvent createFrom(ProductAddedCommand command) {
        return new ProductAddedEvent(command);
    }

    public ProductAddedEvent() {
        super();
    }
}
