package com.example.product.command.store;

import java.util.List;

import com.example.product.command.events.BaseEvent;

public interface EventStore {
    void saveEvent(String aggregateId, BaseEvent event, int expectedVersion);
    List<BaseEvent> getEvents(String aggregateId);
}
