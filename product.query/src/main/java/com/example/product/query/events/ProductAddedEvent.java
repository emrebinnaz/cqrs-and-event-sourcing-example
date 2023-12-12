package com.example.product.query.events;

import java.math.BigDecimal;
import java.util.Date;

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

    public ProductAddedEvent(String id, String name, String description, String status, Date creationDate,
            Integer numberInStock, BigDecimal price, Double discountRatio) {
        super(id);
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.numberInStock = numberInStock;
        this.price = price;
        this.discountRatio = discountRatio;
    }

    public ProductAddedEvent() {
        super();
    }

}
