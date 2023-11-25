package com.example.product.command.aggregate;

import com.example.product.command.commands.ProductAddedCommand;
import com.example.product.command.commands.ProductDeletedCommand;
import com.example.product.command.commands.ProductDiscountedCommand;
import com.example.product.command.commands.ProductStatusChangedCommand;
import com.example.product.command.commands.ProductStockChangedCommand;
import com.example.product.command.commands.ProductUpdatedCommand;
import com.example.product.command.events.ProductAddedEvent;
import com.example.product.command.events.ProductDeletedEvent;
import com.example.product.command.events.ProductDiscountedEvent;
import com.example.product.command.events.ProductStatusChangedEvent;
import com.example.product.command.events.ProductStockChangedEvent;
import com.example.product.command.events.ProductUpdatedEvent;
import com.example.product.command.exception.ProdcutIsNotAvailableException;
import com.example.product.command.exception.ProductIsAlreadyDeletedException;
import com.example.product.command.models.enums.ProductStatus;


public class ProductAggregate extends AggregateRoot {

    private ProductStatus status;
    private boolean isDeleted;
    private Integer numberInStock; 

    public ProductAggregate(ProductAddedCommand command) {
        ProductAddedEvent event = ProductAddedEvent.createFrom(command);
        raise(event);
    }
    public ProductAggregate() {
        
    }
    @Override
    protected void apply(ProductAddedEvent event) {
        this.status = event.getStatus();
        this.isDeleted = false;
        this.numberInStock = event.getNumberInStock();
    }

    public void deleteProduct(ProductDeletedCommand command) {
        ProductDeletedEvent event = ProductDeletedEvent.createFrom(command);
        raise(event);
    }

    @Override
    protected void apply(ProductDeletedEvent event) {
        this.isDeleted = true;
    }

    public void updateProduct(ProductUpdatedCommand command) {
        if(this.isDeleted) {
            throw new ProductIsAlreadyDeletedException("ERROR -> Product is already deleted");
        } 
        ProductUpdatedEvent event = ProductUpdatedEvent.createFrom(command);
        raise(event);
    }
    
    @Override
    protected void apply(ProductUpdatedEvent event) {
        this.status = event.getStatus();
        this.numberInStock = event.getNumberInStock();
    }

    public void changeProductStatus(ProductStatusChangedCommand command) {
        ProductStatusChangedEvent event = ProductStatusChangedEvent.createFrom(command);
        raise(event);
    }
    @Override
    protected void apply(ProductStatusChangedEvent event) {
        this.status = event.getStatus();
    }

    public void changeProductStock(ProductStockChangedCommand command) {
        if(this.isDeleted) {
            throw new ProductIsAlreadyDeletedException("ERROR -> You cannot change the stock of deleted product.");
        }
        if(this.numberInStock == command.getNumberInStock()) {
            return;
        }
        raise(ProductStockChangedEvent.createFrom(command));
    }
    @Override
    protected void apply(ProductStockChangedEvent event) {
        this.numberInStock = event.getNumberInStock();
    }

    public void applyDiscount(ProductDiscountedCommand command) {
        if(this.isDeleted) {
            throw new ProductIsAlreadyDeletedException("ERROR -> You cannot apply discount to deleted product.");
        }
        if(this.status.equals(ProductStatus.NOT_AVAILABLE)) {
            throw new ProdcutIsNotAvailableException("ERROR -> You cannot apply discount to not available product. Please make your product available first.");
        }
        raise(ProductDiscountedEvent.createFrom(command));
    }
    @Override
    protected void apply(ProductDiscountedEvent event) {
        
    }
    
}
