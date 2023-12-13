package com.example.product.command.domain.aggregate;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.product.command.domain.events.BaseEvent;
import com.example.product.command.domain.events.ProductAddedEvent;
import com.example.product.command.domain.events.ProductDeletedEvent;
import com.example.product.command.domain.events.ProductDiscountedEvent;
import com.example.product.command.domain.events.ProductStatusChangedEvent;
import com.example.product.command.domain.events.ProductStockChangedEvent;
import com.example.product.command.domain.events.ProductUpdatedEvent;

public abstract class AggregateRoot {
    protected String id;
    private int version = -1;
    private BaseEvent uncommittedChange;
    private final Logger logger = Logger.getLogger(AggregateRoot.class.getName());

    private final Map<Class<? extends BaseEvent>, Consumer<BaseEvent>> EVENT_APPLY_MAP = Collections.unmodifiableMap(
            new HashMap<>() {{
                put(ProductAddedEvent.class, (baseEvent) -> apply((ProductAddedEvent) baseEvent));
                put(ProductDeletedEvent.class, ((baseEvent) -> apply((ProductDeletedEvent) baseEvent)));
                put(ProductUpdatedEvent.class, ((baseEvent) -> apply((ProductUpdatedEvent) baseEvent)));
                put(ProductStockChangedEvent.class, ((baseEvent) -> apply((ProductStockChangedEvent) baseEvent)));
                put(ProductStatusChangedEvent.class, ((baseEvent) -> apply((ProductStatusChangedEvent) baseEvent)));
                put(ProductDiscountedEvent.class, ((baseEvent) -> apply((ProductDiscountedEvent) baseEvent)));;
            }}
    );


    public String getId() {
        return this.id;
    }
    public int getVersion() {
        return this.version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public BaseEvent getUncommittedChange(){
        return this.uncommittedChange;
    }
    public void markChangeAsCommitted() {
        this.uncommittedChange = null;
    }

    protected void applyChange(BaseEvent baseEvent, Boolean isNewEvent) {
        Consumer<BaseEvent> applyMethod = EVENT_APPLY_MAP.get(baseEvent.getClass());
        if(applyMethod == null) {
            logger.log(Level.WARNING, MessageFormat.format("The apply method was not found in the aggregate for {0}", baseEvent.getClass().getName()));
            throw new NullPointerException();
        }
        applyMethod.accept(baseEvent);
        if(isNewEvent) {
           this.uncommittedChange = baseEvent;
        }

    }
    public void raise(BaseEvent event) {
        this.id = event.getId();
        applyChange(event, true);
    }
    public void replayEvents(Iterable<BaseEvent> events) {
        events.forEach(event -> applyChange(event, false));
    }

    protected abstract void apply(ProductAddedEvent event);
    protected abstract void apply(ProductDeletedEvent event);
    protected abstract void apply(ProductUpdatedEvent event);
    protected abstract void apply(ProductStatusChangedEvent event);
    protected abstract void apply(ProductStockChangedEvent event);
    protected abstract void apply(ProductDiscountedEvent event);
}
