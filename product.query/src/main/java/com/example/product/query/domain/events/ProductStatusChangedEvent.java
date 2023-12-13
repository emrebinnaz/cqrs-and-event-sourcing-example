package com.example.product.query.domain.events;

import lombok.Getter;

@Getter
public final class ProductStatusChangedEvent extends BaseEvent{
    private String status;

    public ProductStatusChangedEvent(String id, String status) {
        super(id);
        this.status = status;
    }
    public ProductStatusChangedEvent() {
        super();
    }
}
