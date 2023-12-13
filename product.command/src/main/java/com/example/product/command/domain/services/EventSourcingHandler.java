package com.example.product.command.domain.services;

import com.example.product.command.domain.aggregate.AggregateRoot;

public interface EventSourcingHandler<T> {

    void save(AggregateRoot aggregateRoot);
    T getLatestStateById(String aggregateId);
}