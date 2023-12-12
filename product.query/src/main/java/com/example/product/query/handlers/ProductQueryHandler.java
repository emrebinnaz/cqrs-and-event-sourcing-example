package com.example.product.query.handlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.product.query.exceptionhandling.ProductNotFoundException;
import com.example.product.query.mappers.ProductMapper;
import com.example.product.query.models.common.enums.ProductStatus;
import com.example.product.query.models.dto.ProductDto;
import com.example.product.query.models.entities.Product;
import com.example.product.query.queries.FindAllProductsBetweenSpecificDatesQuery;
import com.example.product.query.queries.FindAllProductsBetweenSpecificPricesQuery;
import com.example.product.query.queries.FindAllProductsByStatusQuery;
import com.example.product.query.queries.FindAllProductsQuery;
import com.example.product.query.queries.FindByNameQuery;
import com.example.product.query.queries.FindProductByIdQuery;
import com.example.product.query.repositories.ProductRepository;

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
