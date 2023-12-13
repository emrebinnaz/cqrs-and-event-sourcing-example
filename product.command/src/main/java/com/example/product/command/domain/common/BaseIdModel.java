package com.example.product.command.domain.common;

public class BaseIdModel {
    private String id;

    public BaseIdModel(String id) {
        this.id = id;
    }

    public BaseIdModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
