package com.example.product.command.producers;

import com.example.product.command.events.BaseEvent;

public interface EventProducer {
    void produce(BaseEvent baseEvent, String topicName);
}
