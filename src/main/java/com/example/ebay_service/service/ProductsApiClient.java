package com.example.ebay_service.service;

import com.example.ebay_service.model.PageProduct;
import com.example.ebay_service.model.Product;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductsApiClient {

    private final Environment environment;

    @Value("${prop.ebay.url}")
    private String URL;

    private final RestTemplate restTemplate = new RestTemplate();

    public ProductsApiClient(Environment environment) {
        this.environment = environment;
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