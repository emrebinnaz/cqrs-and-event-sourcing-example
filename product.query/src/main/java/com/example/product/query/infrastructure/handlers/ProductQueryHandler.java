package com.example.product.query.infrastructure.handlers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.query.application.dto.ProductDto;
import com.example.product.query.application.exceptions.ProductNotFoundException;
import com.example.product.query.application.mappers.ProductMapper;
import com.example.product.query.application.queries.FindAllProductsBetweenSpecificDatesQuery;
import com.example.product.query.application.queries.FindAllProductsBetweenSpecificPricesQuery;
import com.example.product.query.application.queries.FindAllProductsByStatusQuery;
import com.example.product.query.application.queries.FindAllProductsQuery;
import com.example.product.query.application.queries.FindByNameQuery;
import com.example.product.query.application.queries.FindProductByIdQuery;
import com.example.product.query.application.service.QueryHandler;
import com.example.product.query.domain.entities.Product;
import com.example.product.query.domain.enums.ProductStatus;
import com.example.product.query.domain.repositories.ProductRepository;

@Service
public class ProductQueryHandler implements QueryHandler {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    
    public ProductQueryHandler(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> handle(FindAllProductsBetweenSpecificPricesQuery query) {
        List<Product> products = productRepository.findAllByPriceBetween(query.minPrice(), query.maxPrice());
        return productMapper.mapToDtoList(products);
    }

    @Override
    public List<ProductDto> handle(FindAllProductsBetweenSpecificDatesQuery query) {
        return productMapper.mapToDtoList(productRepository.findAllByCreatedAtBetween(query.startDate(), query.endDate()));
    }

    @Override
    public List<ProductDto> handle(FindAllProductsByStatusQuery query) {
        ProductStatus productStatus = ProductStatus.valueOf(query.status());
        return productMapper.mapToDtoList(productRepository.findAllByStatus(productStatus));
    }

    @Override
    public List<ProductDto> handle(FindAllProductsQuery query) {
        return productMapper.mapToDtoList(productRepository.findAll());
    }

    @Override
    public List<ProductDto> handle(FindByNameQuery query) {
        return productMapper.mapToDtoList(productRepository.findByName(query.name()));
    }

    @Override
    public ProductDto handle(FindProductByIdQuery query) {
        String id = query.id();
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product is not found"));
        return productMapper.maptToDto(product);
    }
    
    
}
