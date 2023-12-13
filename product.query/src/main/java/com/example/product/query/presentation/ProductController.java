package com.example.product.query.presentation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.query.application.dto.ProductDto;
import com.example.product.query.application.queries.FindAllProductsBetweenSpecificDatesQuery;
import com.example.product.query.application.queries.FindAllProductsBetweenSpecificPricesQuery;
import com.example.product.query.application.queries.FindAllProductsByStatusQuery;
import com.example.product.query.application.queries.FindAllProductsQuery;
import com.example.product.query.application.queries.FindByNameQuery;
import com.example.product.query.application.queries.FindProductByIdQuery;
import com.example.product.query.application.service.QueryHandler;
import com.example.product.query.presentation.response.FindAllProductsBetweenSpecificDatesResponse;
import com.example.product.query.presentation.response.FindAllProductsBetweenSpecificPricesResponse;
import com.example.product.query.presentation.response.FindAllProductsByStatusResponse;
import com.example.product.query.presentation.response.FindAllProductsResponse;
import com.example.product.query.presentation.response.FindProductByIdResponse;
import com.example.product.query.presentation.response.FindProductsByNameResponse;




@RestController
@RequestMapping("/products")
public class ProductController {

    private final QueryHandler queryHandler;

    public ProductController(QueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }


    @GetMapping
    public ResponseEntity<FindAllProductsResponse> findAllProducts() {
        List<ProductDto> products = queryHandler.handle(new FindAllProductsQuery());
        return ResponseEntity.ok().body(new FindAllProductsResponse("All products have been retrieved", products));
    }
    
    @GetMapping("/{productId}")
    public ResponseEntity<FindProductByIdResponse> findProductById(@PathVariable("productId") String productId) {
        ProductDto p = queryHandler.handle(new FindProductByIdQuery(productId));
        return ResponseEntity.ok().body(new FindProductByIdResponse("Product has been retrieved", p));
    }

    @GetMapping(params = "name")
    public ResponseEntity<FindProductsByNameResponse> findProductsByName(@RequestParam(required = false) String name) {
        List<ProductDto> productDtos = queryHandler.handle(new FindByNameQuery(name));
        return ResponseEntity.ok().body(new FindProductsByNameResponse("The products which have " + name + " name have been retrieved", productDtos));
    }

    @GetMapping(params = "status")
    public ResponseEntity<FindAllProductsByStatusResponse> findProductsByStatus(@RequestParam(required = false) String status) {
        List<ProductDto> productDtos = queryHandler.handle(new FindAllProductsByStatusQuery(status));
        return ResponseEntity.ok().body(new FindAllProductsByStatusResponse("The products which have " + status + " status have been retrieved", productDtos));
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public ResponseEntity<FindAllProductsBetweenSpecificPricesResponse> findAllProductsBetweenSpecificPrices(@RequestParam(required = false) BigDecimal minPrice, 
                                                                                                             @RequestParam(required = false) BigDecimal maxPrice) {
        List<ProductDto> productDtos = queryHandler.handle(new FindAllProductsBetweenSpecificPricesQuery(minPrice, maxPrice));
        return ResponseEntity.ok().body(new FindAllProductsBetweenSpecificPricesResponse("All products in the price range of " +  minPrice + " and " + maxPrice + " were retrieved. ", productDtos));                              
    }

    @GetMapping(params = {"startDate", "endDate"})
    public ResponseEntity<FindAllProductsBetweenSpecificDatesResponse> findAllProductsBetweenSpecificDates(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, 
                                                                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date endDate) {
        List<ProductDto> productDtos = queryHandler.handle(new FindAllProductsBetweenSpecificDatesQuery(startDate, endDate));
        return ResponseEntity.ok().body(new FindAllProductsBetweenSpecificDatesResponse("All products in between  " +  startDate.toString() + " and " + endDate.toString() + " were retrieved. ", productDtos));
    }
    
    
}
