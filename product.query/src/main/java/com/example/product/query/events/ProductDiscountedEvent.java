package com.example.product.query.events;

import lombok.Getter;

@Getter
public final class ProductDiscountedEvent extends BaseEvent {
    
    private Double discountRatio;

    public ProductDiscountedEvent(String id, Double discountRatio) {
        super(id);
        this.discountRatio = discountRatio;
    }
    
    public ProductDiscountedEvent() {
        super();
    }
    
}
