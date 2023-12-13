package com.example.product.query.application.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private String id;
      private String name;
      private String description;
      private BigDecimal price;
      private Double discountRatio;
      private Integer numberInStock;
      private String status;
}
