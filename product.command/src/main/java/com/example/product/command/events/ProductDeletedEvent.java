package com.example.product.command.events;

import com.example.product.command.commands.ProductDeletedCommand;

public final class ProductDeletedEvent extends BaseEvent {
    private ProductDeletedEvent(ProductDeletedCommand command) {
        super(command.getId());
    }
    public static ProductDeletedEvent createFrom(ProductDeletedCommand command) {
        return new ProductDeletedEvent(command);
    }

    public ProductDeletedEvent() {
        super();
    }
    
}
