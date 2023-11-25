package com.example.product.command.events;

import com.example.product.command.commands.ProductStockChangedCommand;

import lombok.Getter;

@Getter
public final class ProductStockChangedEvent extends BaseEvent {
    private Integer numberInStock;

    private ProductStockChangedEvent(ProductStockChangedCommand command) {
        super(command.getId());
        this.numberInStock = command.getNumberInStock();
    }

    public static ProductStockChangedEvent createFrom(ProductStockChangedCommand command) {
        return new ProductStockChangedEvent(command);
    }
    public ProductStockChangedEvent() {
        super();
    }
}
