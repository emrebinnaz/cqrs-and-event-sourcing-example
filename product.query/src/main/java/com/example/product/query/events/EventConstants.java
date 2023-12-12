package com.example.product.query.events;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EventConstants {
    public static final String PRODUCT_ADDED_EVENT = "ProductAddedEvent";
    public static final String PRODUCT_DELETED_EVENT = "ProductDeletedEvent";
    public static final String PRODUCT_UPDATED_EVENT = "ProductUpdatedEvent";
    public static final String PRODUCT_DISCOUNTED_EVENT = "ProductDiscountedEvent";
    public static final String PRODUCT_STOCK_CHANGED_EVENT = "ProductStockChangedEvent";
    public static final String PRODUCT_STATUS_CHANGED_EVENT = "PRODUCT_STATUS_CHANGED_EVENT";


    public static final Map<String, Class<? extends BaseEvent>> EVENT_CLASS_MAP = Collections.unmodifiableMap(
            new HashMap<>() {{
                put(PRODUCT_ADDED_EVENT, ProductAddedEvent.class);
                put(PRODUCT_DELETED_EVENT, ProductDeletedEvent.class);
                put(PRODUCT_DISCOUNTED_EVENT, ProductDiscountedEvent.class);
                put(PRODUCT_UPDATED_EVENT, ProductUpdatedEvent.class);
                put(PRODUCT_STOCK_CHANGED_EVENT, ProductStockChangedEvent.class);
                put(PRODUCT_STATUS_CHANGED_EVENT, ProductStatusChangedEvent.class);
            }}
    );
}
