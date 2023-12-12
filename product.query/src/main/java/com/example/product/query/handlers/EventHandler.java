package com.example.product.query.handlers;

import com.example.product.query.events.ProductAddedEvent;
import com.example.product.query.events.ProductDeletedEvent;
import com.example.product.query.events.ProductDiscountedEvent;
import com.example.product.query.events.ProductStatusChangedEvent;
import com.example.product.query.events.ProductStockChangedEvent;
import com.example.product.query.events.ProductUpdatedEvent;

public interface EventHandler {

    void on(ProductStockChangedEvent event);
    void on(ProductAddedEvent event);
    void on(ProductDeletedEvent event);
    void on(ProductStatusChangedEvent event);
    void on(ProductUpdatedEvent event);
    void on(ProductDiscountedEvent event);
    
}
