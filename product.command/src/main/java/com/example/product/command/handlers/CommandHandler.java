package com.example.product.command.handlers;

import com.example.product.command.commands.ProductAddedCommand;
import com.example.product.command.commands.ProductStatusChangedCommand;
import com.example.product.command.commands.ProductDeletedCommand;
import com.example.product.command.commands.ProductDiscountedCommand;
import com.example.product.command.commands.ProductStockChangedCommand;
import com.example.product.command.commands.ProductUpdatedCommand;

public interface CommandHandler {
    void handle(ProductAddedCommand command);
    void handle(ProductDeletedCommand command);
    void handle(ProductUpdatedCommand command);
    void handle(ProductStatusChangedCommand command);
    void handle(ProductStockChangedCommand command);
    void handle(ProductDiscountedCommand command);
}
