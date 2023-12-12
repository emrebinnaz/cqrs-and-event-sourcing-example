package com.example.product.query.queries;

import java.util.Date;

public record FindAllProductsBetweenSpecificDatesQuery(Date startDate, Date endDate) {
    
}
