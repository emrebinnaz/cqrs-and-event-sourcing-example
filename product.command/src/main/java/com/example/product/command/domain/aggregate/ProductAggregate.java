package com.example.product.command.domain.aggregate;

import com.example.product.command.application.commands.ProductAddedCommand;
import com.example.product.command.application.commands.ProductDeletedCommand;
import com.example.product.command.application.commands.ProductDiscountedCommand;
import com.example.product.command.application.commands.ProductStatusChangedCommand;
import com.example.product.command.application.commands.ProductStockChangedCommand;
import com.example.product.command.application.commands.ProductUpdatedCommand;
import com.example.product.command.common.enums.ProductStatus;
import com.example.product.command.domain.events.ProductAddedEvent;
import com.example.product.command.domain.events.ProductDeletedEvent;
import com.example.product.command.domain.events.ProductDiscountedEvent;
import com.example.product.command.domain.events.ProductStatusChangedEvent;
import com.example.product.command.domain.events.ProductStockChangedEvent;
import com.example.product.command.domain.events.ProductUpdatedEvent;
import com.example.product.command.domain.exception.ProductIsAlreadyDeletedException;
import com.example.product.command.domain.exception.ProductIsNotAvailableException;


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
        this.status = ProductStatus.valueOf(event.getStatus());
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
        this.status = ProductStatus.valueOf(event.getStatus());
        this.numberInStock = event.getNumberInStock();
    }

    public void changeProductStatus(ProductStatusChangedCommand command) {
        if(this.isDeleted) {
            throw new ProductIsAlreadyDeletedException("ERROR -> You cannot change the status of deleted product.");
        }
        ProductStatusChangedEvent event = ProductStatusChangedEvent.createFrom(command);
        raise(event);
    }
    @Override
    protected void apply(ProductStatusChangedEvent event) {
        this.status = ProductStatus.valueOf(event.getStatus());
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
            throw new ProductIsNotAvailableException("ERROR -> You cannot apply discount to not available product. Please make your product available first.");
        }
        raise(ProductDiscountedEvent.createFrom(command));
    }
    @Override
    protected void apply(ProductDiscountedEvent event) {
        //for now, there is nothing to do in this method.
    }
    
}
