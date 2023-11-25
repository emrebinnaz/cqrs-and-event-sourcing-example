package com.example.product.command.producers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.product.command.events.BaseEvent;

@Service
public class ProductEventProducer implements EventProducer{
    private final KafkaTemplate<String, Object> kafkaTemplate;

    

    public ProductEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void produce(BaseEvent baseEvent, String topicName) {
        this.kafkaTemplate.send(topicName, baseEvent);
    }
    
}
