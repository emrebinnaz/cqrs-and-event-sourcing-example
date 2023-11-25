package com.example.product.command.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.command.commands.ProductAddedCommand;
import com.example.product.command.commands.ProductDeletedCommand;
import com.example.product.command.commands.ProductDiscountedCommand;
import com.example.product.command.commands.ProductStatusChangedCommand;
import com.example.product.command.commands.ProductStockChangedCommand;
import com.example.product.command.commands.ProductUpdatedCommand;
import com.example.product.command.handlers.CommandHandler;
import com.example.product.command.models.requests.AddProductRequest;
import com.example.product.command.models.requests.ApplyDiscountRequest;
import com.example.product.command.models.requests.ProductStatusChangedRequest;
import com.example.product.command.models.requests.ProductStockChangedRequest;
import com.example.product.command.models.requests.UpdateProductRequest;
import com.example.product.command.models.response.BaseResponse;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
public class ProductContoller {
    
    private final CommandHandler commandHandler;

    public ProductContoller(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> addProduct(@RequestBody @Valid AddProductRequest request) {
        ProductAddedCommand command = new ProductAddedCommand(request);
        commandHandler.handle(command);
        BaseResponse baseResponse = new BaseResponse("Product with " + command.getId() + " id was created");

        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<BaseResponse> deleteProduct(@PathVariable String productId) {
        ProductDeletedCommand command = new ProductDeletedCommand(productId);
        commandHandler.handle(command);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(path = "/{productId}")
    public ResponseEntity<BaseResponse> updateProduct(@PathVariable String productId, @RequestBody @Valid UpdateProductRequest request) {
        ProductUpdatedCommand command = new ProductUpdatedCommand(request, productId);
        commandHandler.handle(command);
        BaseResponse baseResponse = new BaseResponse("Product has been updated");
        return ResponseEntity.ok(baseResponse);

    }


    @PatchMapping(path = "/{productId}/discount")
    public ResponseEntity<BaseResponse> applyDiscount(@PathVariable String productId, @RequestBody @Valid ApplyDiscountRequest req) {
        ProductDiscountedCommand command = new ProductDiscountedCommand(productId, req.getDiscountRatio());
        commandHandler.handle(command);
        BaseResponse baseResponse = new BaseResponse("Discount has been applied.");
        return ResponseEntity.ok(baseResponse);

    }

    @PatchMapping(path = "/{productId}/status")
    public ResponseEntity<BaseResponse> changeProductStatus(@PathVariable String productId, @RequestBody @Valid ProductStatusChangedRequest req) {
        ProductStatusChangedCommand command = new ProductStatusChangedCommand(productId, req);
        commandHandler.handle(command);
        BaseResponse baseResponse = new BaseResponse("Product status has been changed as " + " " + req.getStatus().toString() + " .");
        return ResponseEntity.ok(baseResponse);

    }

    @PatchMapping(path = "/{productId}/stock")
    public ResponseEntity<BaseResponse> changeProductStock(@PathVariable String productId, @RequestBody @Valid ProductStockChangedRequest req) {
        ProductStockChangedCommand command = new ProductStockChangedCommand(productId, req);
        commandHandler.handle(command);
        BaseResponse baseResponse = new BaseResponse("Product stock has been changed as " + " " + req.getStock().toString() + " .");
        return ResponseEntity.ok(baseResponse);

    }
    
}
