package com.example.product.command.commands;

import com.example.product.command.models.common.BaseIdModel;

public abstract class BaseCommand extends BaseIdModel{

    public BaseCommand(String id) {
        super(id);
    }
    
}
