package com.example.product.command.domain.store;

import java.util.List;

import com.example.product.command.domain.events.BaseEvent;

public interface EventStore {
    void saveEvent(String aggregateId, BaseEvent event, int expectedVersion);
    List<BaseEvent> getEvents(String aggregateId);
}
