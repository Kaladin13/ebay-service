package com.example.ebay_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductsApiClient {

    private static final String URL = "https://localhost:8023/products-1.0-SNAPSHOT/api";
    private final RestTemplate restTemplate;

    public ProductsApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void updatePrice(float percent) {
        List<Product> products = getAllProducts();
        products.forEach(product -> product.setPrice(product.getPrice() * percent));
        updateProducts(products);
    }

    public List<Product> getAllProducts() {
        PageProduct response = restTemplate.postForObject(URL + "/products/bulk?size=" + Integer.MAX_VALUE, "[]", PageProduct.class);
        return response.getContent();
    }

    private void updateProducts(List<Product> products) {
        for (Product product : products) {
            restTemplate.put(URL + "/products/" + product.getId(), product);
        }
    }
}