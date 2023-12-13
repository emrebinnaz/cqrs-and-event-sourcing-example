package com.example.product.query.domain.events;

public final class ProductDeletedEvent extends BaseEvent {
    
    public ProductDeletedEvent(String id) {
        super(id);
    }
    public ProductDeletedEvent() {
        super();
    }
    
}

