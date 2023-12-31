package com.example.product.command.domain.events;

import com.example.product.command.application.commands.ProductDiscountedCommand;

import lombok.Getter;

@Getter
public final class ProductDiscountedEvent extends BaseEvent {
    
    private Double discountRatio;

    private ProductDiscountedEvent(ProductDiscountedCommand command) {
        super(command.getId());
        this.discountRatio = command.getDiscountRatio();
    }

    public static ProductDiscountedEvent createFrom(ProductDiscountedCommand command) {
        return new ProductDiscountedEvent(command);

    }
    
    public ProductDiscountedEvent() {
        super();
    }
    
}
