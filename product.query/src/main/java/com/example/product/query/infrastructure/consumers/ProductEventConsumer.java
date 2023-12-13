package com.example.product.query.infrastructure.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.example.product.query.domain.events.EventConstants;
import com.example.product.query.domain.events.ProductAddedEvent;
import com.example.product.query.domain.events.ProductDeletedEvent;
import com.example.product.query.domain.events.ProductDiscountedEvent;
import com.example.product.query.domain.events.ProductStatusChangedEvent;
import com.example.product.query.domain.events.ProductStockChangedEvent;
import com.example.product.query.domain.events.ProductUpdatedEvent;
import com.example.product.query.domain.service.EventHandler;

@Service
public class ProductEventConsumer implements EventConsumer{
    private final EventHandler eventHandler;
    
    public ProductEventConsumer(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
     @KafkaListener(topics = EventConstants.PRODUCT_ADDED_EVENT, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ProductAddedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    @Override
    @KafkaListener(topics = EventConstants.PRODUCT_DELETED_EVENT, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ProductDeletedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    @Override
    @KafkaListener(topics = EventConstants.PRODUCT_UPDATED_EVENT, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ProductUpdatedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    @Override
    @KafkaListener(topics = EventConstants.PRODUCT_STATUS_CHANGED_EVENT, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ProductStatusChangedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    @Override
    @KafkaListener(topics = EventConstants.PRODUCT_STOCK_CHANGED_EVENT, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ProductStockChangedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    @Override
    @KafkaListener(topics = EventConstants.PRODUCT_DISCOUNTED_EVENT, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ProductDiscountedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }
    
}
