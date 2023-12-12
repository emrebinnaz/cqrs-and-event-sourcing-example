package com.example.product.query.events;

public final class ProductDeletedEvent extends BaseEvent {
    
    public ProductDeletedEvent(String id) {
        super(id);
    }
    public ProductDeletedEvent() {
        super();
    }
    
}

