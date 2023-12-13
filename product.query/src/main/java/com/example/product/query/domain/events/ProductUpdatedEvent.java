package com.example.product.query.domain.events;

import java.math.BigDecimal;
import java.util.Date;

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

    public ProductUpdatedEvent(String id, String name, String description, String status, Date updateDate,
                                Integer numberInStock, BigDecimal price, Double discountRatio) {
        super(id);
        this.updateDate = updateDate;
        this.description = description;
        this.name = name;
        this.status = status;
        this.numberInStock = numberInStock;
        this.discountRatio = discountRatio;
        this.price = price;
    }
    
    public ProductUpdatedEvent() {
        super();
    }
}
