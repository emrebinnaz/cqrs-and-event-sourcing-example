package com.example.product.query.deserializers;

import com.example.product.query.events.BaseEvent;
import com.example.product.query.events.EventConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class CustomDeserializer implements Deserializer<BaseEvent> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public BaseEvent deserialize(String topicName, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), EventConstants.EVENT_CLASS_MAP.get(topicName));
        } catch (Exception e) {
            throw new SerializationException(e.getMessage());
        }
    }
    @Override
    public void close() {
        Deserializer.super.close();
    }
}
