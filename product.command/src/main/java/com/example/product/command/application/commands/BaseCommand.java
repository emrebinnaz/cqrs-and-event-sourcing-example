package com.example.product.command.application.commands;

import com.example.product.command.domain.common.BaseIdModel;

public abstract class BaseCommand extends BaseIdModel{

    public BaseCommand(String id) {
        super(id);
    }
    
}
