package com.example.ebay_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/price")
@Validated
public class PriceController {

    @Autowired
    private ProductsApiClient productsApiClient;

    @PostMapping("/increase/{increasePercent}")
    public ResponseEntity<Void> increasePrice(@PathVariable("increasePercent") @Valid @Min(0) float percent) {
        productsApiClient.updatePrice(1 + percent);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/decrease/{decreasePercent}")
    public ResponseEntity<Void> decreasePrice(@PathVariable("decreasePercent") @Valid @Min(0) float percent) {
        if (percent >= 1) {
            return ResponseEntity.badRequest().build();
        }
        productsApiClient.updatePrice(1 - percent);
        return ResponseEntity.ok().build();
    }
}