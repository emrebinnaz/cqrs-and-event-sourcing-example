package com.example.product.query.application.queries;

import java.math.BigDecimal;

public record FindAllProductsBetweenSpecificPricesQuery(BigDecimal minPrice, BigDecimal maxPrice) {
    
}
