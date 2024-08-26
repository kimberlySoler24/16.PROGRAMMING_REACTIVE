package com.reactive.programming.reactive_programming.models.dto;

public class ItemDto {
    private String name;

    public ItemDto() {
    }

    public ItemDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
