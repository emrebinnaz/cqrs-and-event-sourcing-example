package com.example.product.query.domain.events;

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

