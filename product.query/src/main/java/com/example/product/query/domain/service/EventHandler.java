package com.example.product.query.domain.service;

import com.example.product.query.domain.events.ProductAddedEvent;
import com.example.product.query.domain.events.ProductDeletedEvent;
import com.example.product.query.domain.events.ProductDiscountedEvent;
import com.example.product.query.domain.events.ProductStatusChangedEvent;
import com.example.product.query.domain.events.ProductStockChangedEvent;
import com.example.product.query.domain.events.ProductUpdatedEvent;

public interface EventHandler {

    void on(ProductStockChangedEvent event);
    void on(ProductAddedEvent event);
    void on(ProductDeletedEvent event);
    void on(ProductStatusChangedEvent event);
    void on(ProductUpdatedEvent event);
    void on(ProductDiscountedEvent event);
    
}
