package com.example.product.command.infrastructure.store;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.product.command.domain.aggregate.ProductAggregate;
import com.example.product.command.domain.entity.EventModel;
import com.example.product.command.domain.events.BaseEvent;
import com.example.product.command.domain.exception.AggregateNotFoundException;
import com.example.product.command.domain.exception.OptimisticConcurrencyException;
import com.example.product.command.domain.repository.EventStoreRepository;
import com.example.product.command.domain.store.EventStore;
import com.example.product.command.infrastructure.producers.EventProducer;

@Service
public class ProductEventStore implements EventStore{
    private final EventProducer eventProducer;
    private final EventStoreRepository eventStoreRepository;
    
    public ProductEventStore(EventStoreRepository eventStoreRepository, EventProducer eventProducer) {
        this.eventStoreRepository = eventStoreRepository;
        this.eventProducer = eventProducer;
    }

    @Override
    public void saveEvent(String aggregateId, BaseEvent event, int expectedVersion) {
        List<EventModel> eventModels = eventStoreRepository.findByAggregateIdentifier(aggregateId);
        if(expectedVersion != -1 && eventModels.get(eventModels.size() - 1).getVersion() != expectedVersion) {
            throw new OptimisticConcurrencyException("ERROR ! Optimistic concurrency exception during fetching of event models.");
        }
        int version = expectedVersion;
        version++;
        event.setVersion(version);

        EventModel eventModel = new EventModel();
        eventModel.setTimeStamp(new Date());
        eventModel.setAggregateIdentifier(aggregateId);
        eventModel.setAggregateType(ProductAggregate.class.getTypeName());
        eventModel.setVersion(version);
        eventModel.setEventType(event.getClass().getTypeName());
        eventModel.setEvent(event);

        EventModel persistedEventModel = eventStoreRepository.save(eventModel);
        if ( !persistedEventModel.getId().isEmpty()) {
            eventProducer.produce(event, event.getClass().getSimpleName());
        }
    }

    @Override
    public List<BaseEvent> getEvents(String aggregateId) {
        List<EventModel> byAggregateIdentifier = eventStoreRepository.findByAggregateIdentifier(aggregateId);
        if( byAggregateIdentifier == null || byAggregateIdentifier.isEmpty()) {
            throw new AggregateNotFoundException("ERROR ! Incorrect product ID provided !");
        }
        return byAggregateIdentifier.stream().map(EventModel::getEvent).collect(Collectors.toList());
    }
    
}
