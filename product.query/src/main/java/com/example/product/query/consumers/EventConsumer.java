package com.example.product.query.consumers;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

import com.example.product.query.events.ProductAddedEvent;
import com.example.product.query.events.ProductDeletedEvent;
import com.example.product.query.events.ProductDiscountedEvent;
import com.example.product.query.events.ProductStatusChangedEvent;
import com.example.product.query.events.ProductStockChangedEvent;
import com.example.product.query.events.ProductUpdatedEvent;

public interface EventConsumer {

    void consume(@Payload ProductAddedEvent event, Acknowledgment acknowledgment);
    void consume(@Payload ProductDeletedEvent event, Acknowledgment acknowledgment);
    void consume(@Payload ProductUpdatedEvent event, Acknowledgment acknowledgment);
    void consume(@Payload ProductStatusChangedEvent event, Acknowledgment acknowledgment);
    void consume(@Payload ProductStockChangedEvent event, Acknowledgment acknowledgment);
    void consume(@Payload ProductDiscountedEvent event, Acknowledgment acknowledgment);

}