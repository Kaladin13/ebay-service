package com.example.ebay_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Person {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("weight")
    @NotNull(message = "Weight cannot be null")
    @Positive(message = "Weight must be greater than 0")
    private Double weight;

    @JsonProperty("eyeColor")
    private Color eyeColor;

    @JsonProperty("hairColor")
    @NotNull(message = "Hair color cannot be null")
    private Color hairColor;


    @JsonCreator
    public Person(Long id, String name, String birthday, Double weight, Color eyeColor, Color hairColor) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }
}
