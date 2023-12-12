package com.example.product.command.events;

import java.math.BigDecimal;
import java.util.Date;

import com.example.product.command.commands.ProductUpdatedCommand;
import com.example.product.command.models.enums.ProductStatus;

import lombok.Getter;

@Getter
public final class ProductUpdatedEvent extends BaseEvent {
    private String name;
    private String description;
    private String status;
    private Date updateDate;
    private Integer numberInStock;
    private BigDecimal price;
    private Double discountRatio;

    private ProductUpdatedEvent(ProductUpdatedCommand command) {
        super(command.getId());
        this.updateDate = command.getUpdateDate();
        this.description = command.getDescription();
        this.name = command.getName();
        this.status = command.getStatus().name();
        this.numberInStock = command.getNumberInStock();
        this.discountRatio = command.getDiscountRatio();
        this.price = command.getPrice();
    }
    
    public static ProductUpdatedEvent createFrom(ProductUpdatedCommand command) {
        return new ProductUpdatedEvent(command);
    }
    public ProductUpdatedEvent() {
        super();
    }
}
