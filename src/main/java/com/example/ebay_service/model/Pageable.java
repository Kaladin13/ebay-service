package com.example.ebay_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pageable {

    @JsonProperty("pageNumber")
    private int pageNumber;

    @JsonProperty("pageSize")
    private int pageSize;

    @JsonCreator
    public Pageable(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Pageable() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }
}
