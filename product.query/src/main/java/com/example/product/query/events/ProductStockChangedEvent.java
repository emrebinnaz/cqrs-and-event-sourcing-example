package com.example.product.query.events;

import lombok.Getter;

@Getter
public final class ProductStockChangedEvent extends BaseEvent {
    private Integer numberInStock;

    public ProductStockChangedEvent(String id, Integer numberInStock) {
        super(id);
        this.numberInStock = numberInStock;
    }

    public ProductStockChangedEvent() {
        super();
    }
}

