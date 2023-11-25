package com.example.product.command.models.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.product.command.events.BaseEvent;
@Document(collection = "eventStore")
public class EventModel {

    @Id
    private String id;
    private Date timeStamp;
    private String aggregateIdentifier;
    private String aggregateType;
    private int version;
    private String eventType;
    private BaseEvent event;

    public EventModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAggregateIdentifier() {
        return aggregateIdentifier;
    }

    public void setAggregateIdentifier(String aggregateIdentifier) {
        this.aggregateIdentifier = aggregateIdentifier;
    }

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public BaseEvent getEvent() {
        return event;
    }

    public void setEvent(BaseEvent event) {
        this.event = event;
    }
}
