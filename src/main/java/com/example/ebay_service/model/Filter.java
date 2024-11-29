package com.example.ebay_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class Filter {

    @JsonProperty("fieldType")
    @NotNull
    private final FieldType fieldType;

    @JsonProperty("value")
    private final String value;

    @JsonCreator
    public Filter(FieldType fieldType, String value) {
        this.fieldType = fieldType;
        this.value = value;
    }

    public @NotNull FieldType getFieldType() {
        return fieldType;
    }

    public String getValue() {
        return value;
    }
}
