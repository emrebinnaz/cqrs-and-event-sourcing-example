package com.example.product.command.handlers;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.product.command.aggregate.AggregateRoot;
import com.example.product.command.aggregate.ProductAggregate;
import com.example.product.command.events.BaseEvent;
import com.example.product.command.store.EventStore;

@Service
public class ProductEventSourcingHandler implements EventSourcingHandler<ProductAggregate>{

    private final EventStore eventStore;

    public ProductEventSourcingHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void save(AggregateRoot aggregateRoot) {
        eventStore.saveEvent(aggregateRoot.getId(), aggregateRoot.getUncommittedChange(), aggregateRoot.getVersion());
        aggregateRoot.markChangeAsCommitted();
    }

    @Override
    public ProductAggregate getLatestStateById(String aggregateId) {
         ProductAggregate aggregate = new ProductAggregate();
        List<BaseEvent> events = eventStore.getEvents(aggregateId);
        if(events != null && !events.isEmpty()) {
            aggregate.replayEvents(events);
            Optional<Integer> maxVersion = events.stream().map(x -> x.getVersion()).max(Comparator.naturalOrder());
            aggregate.setVersion(maxVersion.get());
        }
        return aggregate;
    }
    
}
