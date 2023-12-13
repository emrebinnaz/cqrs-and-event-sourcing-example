package com.example.product.query.application.service;

import java.util.List;

import com.example.product.query.application.dto.ProductDto;
import com.example.product.query.application.queries.FindAllProductsBetweenSpecificDatesQuery;
import com.example.product.query.application.queries.FindAllProductsBetweenSpecificPricesQuery;
import com.example.product.query.application.queries.FindAllProductsByStatusQuery;
import com.example.product.query.application.queries.FindAllProductsQuery;
import com.example.product.query.application.queries.FindByNameQuery;
import com.example.product.query.application.queries.FindProductByIdQuery;

public interface QueryHandler {
    List<ProductDto> handle(FindAllProductsBetweenSpecificPricesQuery query);
    List<ProductDto> handle(FindAllProductsBetweenSpecificDatesQuery query);
    List<ProductDto> handle(FindAllProductsByStatusQuery query);
    List<ProductDto> handle(FindAllProductsQuery query);
    List<ProductDto> handle(FindByNameQuery query);
    ProductDto handle(FindProductByIdQuery query);
}
