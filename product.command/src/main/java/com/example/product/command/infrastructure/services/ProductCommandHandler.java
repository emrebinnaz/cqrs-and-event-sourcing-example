package com.example.product.command.infrastructure.services;

import org.springframework.stereotype.Service;

import com.example.product.command.application.commands.ProductAddedCommand;
import com.example.product.command.application.commands.ProductDeletedCommand;
import com.example.product.command.application.commands.ProductDiscountedCommand;
import com.example.product.command.application.commands.ProductStatusChangedCommand;
import com.example.product.command.application.commands.ProductStockChangedCommand;
import com.example.product.command.application.commands.ProductUpdatedCommand;
import com.example.product.command.application.services.CommandHandler;
import com.example.product.command.domain.aggregate.ProductAggregate;
import com.example.product.command.domain.services.EventSourcingHandler;

@Service
public class ProductCommandHandler implements CommandHandler {
    private final EventSourcingHandler<ProductAggregate> eventSourcingHandler;

    public ProductCommandHandler(EventSourcingHandler<ProductAggregate> eventSourcingHandler) {
        this.eventSourcingHandler = eventSourcingHandler;
    }

    @Override
    public void handle(ProductAddedCommand command) {
        ProductAggregate aggregate = new ProductAggregate(command);
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(ProductDeletedCommand command) {
        ProductAggregate productAggregate = eventSourcingHandler.getLatestStateById(command.getId());
        productAggregate.deleteProduct(command);
        eventSourcingHandler.save(productAggregate);
    }

    @Override
    public void handle(ProductUpdatedCommand command) {
        
        ProductAggregate productAggregate = eventSourcingHandler.getLatestStateById(command.getId());
        productAggregate.updateProduct(command);
        eventSourcingHandler.save(productAggregate);
    }

    @Override
    public void handle(ProductStatusChangedCommand command) {
        ProductAggregate productAggregate = eventSourcingHandler.getLatestStateById(command.getId());
        productAggregate.changeProductStatus(command);
        eventSourcingHandler.save(productAggregate);
    }

    @Override
    public void handle(ProductStockChangedCommand command) {
        ProductAggregate productAggregate = eventSourcingHandler.getLatestStateById(command.getId());
        productAggregate.changeProductStock(command);
        eventSourcingHandler.save(productAggregate);
    }

    @Override
    public void handle(ProductDiscountedCommand command) {
        ProductAggregate productAggregate = eventSourcingHandler.getLatestStateById(command.getId());
        productAggregate.applyDiscount(command);
        eventSourcingHandler.save(productAggregate);
    }
}
