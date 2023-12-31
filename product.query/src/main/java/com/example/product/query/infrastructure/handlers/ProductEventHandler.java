package com.example.product.query.infrastructure.handlers;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.product.query.domain.entities.Product;
import com.example.product.query.domain.enums.ProductStatus;
import com.example.product.query.domain.events.ProductAddedEvent;
import com.example.product.query.domain.events.ProductDeletedEvent;
import com.example.product.query.domain.events.ProductDiscountedEvent;
import com.example.product.query.domain.events.ProductStatusChangedEvent;
import com.example.product.query.domain.events.ProductStockChangedEvent;
import com.example.product.query.domain.events.ProductUpdatedEvent;
import com.example.product.query.domain.repositories.ProductRepository;
import com.example.product.query.domain.service.EventHandler;

@Service
public class ProductEventHandler implements EventHandler{

    private final ProductRepository productRepository;
    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void on(ProductStockChangedEvent event) {
        Product product = productRepository.findById(event.getId()).get();
        product.setNumberInStock(event.getNumberInStock());
        productRepository.save(product);
    }

    @Override
    public void on(ProductAddedEvent event) {
      Product product = new Product(event);
      productRepository.save(product);
    }

    @Override
    public void on(ProductDeletedEvent event) {
        productRepository.deleteById(event.getId());
    }

    @Override
    public void on(ProductStatusChangedEvent event) {
    
        Product product = productRepository.findById(event.getId()).get();
        product.setStatus(ProductStatus.valueOf(event.getStatus()));
        productRepository.save(product);
    }

    @Override
    public void on(ProductUpdatedEvent event) {
        Product product = productRepository.findById(event.getId()).get();
        product.setStatus(ProductStatus.valueOf(event.getStatus()));
        product.setDescription(event.getDescription());
        product.setDiscountRatio(event.getDiscountRatio());
        product.setNumberInStock(event.getNumberInStock());
        product.setName(event.getName());
        if(event.getDiscountRatio() == 0) {
            product.setPrice(event.getPrice());
        } else {
            BigDecimal discountRatio = new BigDecimal(Double.toString(event.getDiscountRatio()));
            BigDecimal discountedAmount = event.getPrice().multiply(discountRatio.divide(new BigDecimal(100)));
            product.setPrice(event.getPrice().subtract(discountedAmount));
        }
        productRepository.save(product);
    }

    @Override
    public void on(ProductDiscountedEvent event) {
        Product product = productRepository.findById(event.getId()).get();
        product.applyDiscount(event.getDiscountRatio());
        productRepository.save(product);
    }
    
}
