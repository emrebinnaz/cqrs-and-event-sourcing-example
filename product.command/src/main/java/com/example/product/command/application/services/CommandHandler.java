package com.example.product.command.application.services;

import com.example.product.command.application.commands.ProductAddedCommand;
import com.example.product.command.application.commands.ProductDeletedCommand;
import com.example.product.command.application.commands.ProductDiscountedCommand;
import com.example.product.command.application.commands.ProductStatusChangedCommand;
import com.example.product.command.application.commands.ProductStockChangedCommand;
import com.example.product.command.application.commands.ProductUpdatedCommand;

public interface CommandHandler {
    void handle(ProductAddedCommand command);
    void handle(ProductDeletedCommand command);
    void handle(ProductUpdatedCommand command);
    void handle(ProductStatusChangedCommand command);
    void handle(ProductStockChangedCommand command);
    void handle(ProductDiscountedCommand command);
}
