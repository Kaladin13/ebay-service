package com.example.ebay_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PageProduct {
    @JsonProperty("content")
    private List<Product> content;

    @JsonProperty("pageable")
    private Pageable pageable;

    @JsonProperty("totalPages")
    private int totalPages;

    @JsonProperty("totalElements")
    private int totalElements;

    @JsonCreator
    public PageProduct(List<Product> content, Pageable pageable, int totalPages, int totalElements) {
        this.content = content;
        this.pageable = pageable;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public PageProduct() {
    }

    public List<Product> getContent() {
        return content;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }
}