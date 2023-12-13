package com.example.product.query.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

import com.example.product.query.domain.entities.Product;
import com.example.product.query.domain.enums.ProductStatus;

import java.math.BigDecimal;

public interface ProductRepository extends MongoRepository<Product, String>{
    
    List<Product> findAll();
    Optional<Product> findById(String id);
    List<Product> findByName(String name);
    List<Product> findAllByCreatedAtBetween(Date startDate, Date endDate);
    List<Product> findAllByStatus(ProductStatus status);
    List<Product> findAllByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
}
