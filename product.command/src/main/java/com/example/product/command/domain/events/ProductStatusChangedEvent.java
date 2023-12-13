package com.example.product.command.domain.events;

import com.example.product.command.application.commands.ProductStatusChangedCommand;

import lombok.Getter;

@Getter
public final class ProductStatusChangedEvent extends BaseEvent{
    private String status;

    private ProductStatusChangedEvent(ProductStatusChangedCommand command) {
        super(command.getId());
        this.status = command.getStatus().name();
    }

    public static ProductStatusChangedEvent createFrom(ProductStatusChangedCommand command) {
        return new ProductStatusChangedEvent(command);
    }
    public ProductStatusChangedEvent() {
        super();
    }
}
