package com.example.product.command.handlers;

import org.springframework.stereotype.Service;

import com.example.product.command.aggregate.ProductAggregate;
import com.example.product.command.commands.ProductAddedCommand;
import com.example.product.command.commands.ProductDeletedCommand;
import com.example.product.command.commands.ProductDiscountedCommand;
import com.example.product.command.commands.ProductStatusChangedCommand;
import com.example.product.command.commands.ProductStockChangedCommand;
import com.example.product.command.commands.ProductUpdatedCommand;

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
