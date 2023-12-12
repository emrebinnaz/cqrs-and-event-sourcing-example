package com.example.product.query.queries;

import java.math.BigDecimal;

public record FindAllProductsBetweenSpecificPricesQuery(BigDecimal minPrice, BigDecimal maxPrice) {
    
}
