package com.example.product.command.infrastructure.producers;

import com.example.product.command.domain.events.BaseEvent;

public interface EventProducer {
    void produce(BaseEvent baseEvent, String topicName);
}
