package com.example.product.query.domain.events;

import com.example.product.query.domain.common.BaseIdModel;

public abstract class BaseEvent extends BaseIdModel {
    private int version;

    public BaseEvent(String id) {
        super(id);
    }

    public BaseEvent(String id, int version) {
        super(id);
        this.version = version;
    }

    public BaseEvent() {
        super();
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
