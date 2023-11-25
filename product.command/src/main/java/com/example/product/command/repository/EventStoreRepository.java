package com.example.product.command.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.product.command.models.entity.EventModel;

@Repository
public interface EventStoreRepository extends MongoRepository<EventModel, String> {
    List<EventModel> findByAggregateIdentifier(String aggregateIdentifier);
}
