package com.example.product.query.application.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.product.query.application.dto.ProductDto;
import com.example.product.query.domain.entities.Product;

@Component
public class ProductMapper {

    public ProductDto maptToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setDescription(product.getDescription());
        dto.setDiscountRatio(product.getDiscountRatio());
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setNumberInStock(product.getNumberInStock());
        dto.setPrice(product.getPrice());
        dto.setStatus(product.getStatus().name());
        
        return dto;

    }
    
    public List<ProductDto> mapToDtoList(List<Product> products) {
        return products.stream().map(this::maptToDto).toList();
    }
}
