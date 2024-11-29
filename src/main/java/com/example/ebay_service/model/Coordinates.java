package com.example.ebay_service.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {
    private double x; // Поле не может быть null
    private double y; // Значение поля должно быть больше -110, Поле не может быть null

    @JsonCreator
    public Coordinates(@JsonProperty("x") double x, @JsonProperty("y") double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

