package com.example.product.command.handlers;

import com.example.product.command.aggregate.AggregateRoot;

public interface EventSourcingHandler<T> {

    void save(AggregateRoot aggregateRoot);
    T getLatestStateById(String aggregateId);
}