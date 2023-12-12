package com.example.product.query.handlers;

import java.util.List;

import com.example.product.query.models.dto.ProductDto;
import com.example.product.query.queries.FindAllProductsBetweenSpecificDatesQuery;
import com.example.product.query.queries.FindAllProductsBetweenSpecificPricesQuery;
import com.example.product.query.queries.FindAllProductsByStatusQuery;
import com.example.product.query.queries.FindAllProductsQuery;
import com.example.product.query.queries.FindByNameQuery;
import com.example.product.query.queries.FindProductByIdQuery;

public interface QueryHandler {
    List<ProductDto> handle(FindAllProductsBetweenSpecificPricesQuery query);
    List<ProductDto> handle(FindAllProductsBetweenSpecificDatesQuery query);
    List<ProductDto> handle(FindAllProductsByStatusQuery query);
    List<ProductDto> handle(FindAllProductsQuery query);
    List<ProductDto> handle(FindByNameQuery query);
    ProductDto handle(FindProductByIdQuery query);
}
