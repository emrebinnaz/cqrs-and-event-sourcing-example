package com.example.product.query.application.queries;

import java.util.Date;

public record FindAllProductsBetweenSpecificDatesQuery(Date startDate, Date endDate) {
    
}
