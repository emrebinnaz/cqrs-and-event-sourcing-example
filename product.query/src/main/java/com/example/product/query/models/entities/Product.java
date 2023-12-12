package com.example.product.query.models.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import com.example.product.query.events.ProductAddedEvent;
import com.example.product.query.models.common.enums.ProductStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
      @Id
      private String id;
      private String name;
      private String description;
      private Date createdAt;
      private Date updatedAt;
      @Field(targetType = FieldType.DECIMAL128)
      private BigDecimal price;
      private Double discountRatio;
      private Integer numberInStock;
      private ProductStatus status;

      public Product(ProductAddedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.createdAt = event.getCreationDate();
        this.numberInStock = event.getNumberInStock();
        this.status = ProductStatus.valueOf(event.getStatus());
      }


    public void applyDiscount(Double discountRatio) {

        this.setDiscountRatio(discountRatio);
        if(discountRatio == 0)  {    
            return;
        }
        BigDecimal discountRatioAsBigDecimal = new BigDecimal(Double.toString(discountRatio));
        BigDecimal discountedAmount = this.getPrice().multiply(discountRatioAsBigDecimal.divide(new BigDecimal(100)));
        this.setPrice(this.getPrice().subtract(discountedAmount));
      
    }
}
