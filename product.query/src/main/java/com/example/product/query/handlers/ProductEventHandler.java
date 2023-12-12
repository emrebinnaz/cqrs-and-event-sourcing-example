package com.example.product.query.handlers;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.product.query.events.ProductAddedEvent;
import com.example.product.query.events.ProductDeletedEvent;
import com.example.product.query.events.ProductDiscountedEvent;
import com.example.product.query.events.ProductStatusChangedEvent;
import com.example.product.query.events.ProductStockChangedEvent;
import com.example.product.query.events.ProductUpdatedEvent;
import com.example.product.query.models.common.enums.ProductStatus;
import com.example.product.query.models.entities.Product;
import com.example.product.query.repositories.ProductRepository;

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
