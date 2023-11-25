package com.example.product.command.events;

import com.example.product.command.commands.ProductStatusChangedCommand;
import com.example.product.command.models.enums.ProductStatus;

import lombok.Getter;

@Getter
public final class ProductStatusChangedEvent extends BaseEvent{
    private ProductStatus status;

    private ProductStatusChangedEvent(ProductStatusChangedCommand command) {
        super(command.getId());
        this.status = command.getStatus();
    }

    public static ProductStatusChangedEvent createFrom(ProductStatusChangedCommand command) {
        return new ProductStatusChangedEvent(command);
    }
    public ProductStatusChangedEvent() {
        super();
    }
}
