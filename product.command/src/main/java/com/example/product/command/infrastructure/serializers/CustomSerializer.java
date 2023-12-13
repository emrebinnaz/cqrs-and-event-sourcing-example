package com.example.product.command.infrastructure.serializers;

import com.example.product.command.domain.events.BaseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<BaseEvent> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, BaseEvent data) {
        try {
            if (data == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing data to byte[]");
        }
    }

    @Override
    public void close() {
    }
}