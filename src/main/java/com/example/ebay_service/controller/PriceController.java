package com.example.ebay_service.controller;

import com.example.ebay_service.exception.SoapErrorDto;
import com.example.ebay_service.exception.ValidationException;
import com.example.ebay_service.model.DecreasePriceRequest;
import com.example.ebay_service.model.IncreasePriceRequest;
import com.example.ebay_service.model.PriceResponse;
import com.example.ebay_service.service.ProductsApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PriceController {

    private static final String NAMESPACE_URI = "http://188.225.56.32:8080/ebay-service/ws";

    @Autowired
    private ProductsApiClient productsApiClient;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IncreasePriceRequest")
    @ResponsePayload
    public PriceResponse increasePrice(@RequestPayload IncreasePriceRequest request) {
        Float percent = request.getPricePercent();
        if (percent == null) {
            throw new ValidationException(
                    "Percent cannot be null",
                    new SoapErrorDto("400", "Percent cannot be null")
            );
        }
        if (percent >= 1 || percent <= 0) {
            throw new ValidationException(
                    "Increase percentage must be less than 1 and more than 0",
                    new SoapErrorDto("400", "Increase percentage must be less than 1 and more than 0")
            );
        }
        productsApiClient.updatePrice(1 + percent);

        return new PriceResponse("OK");
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DecreasePriceRequest")
    @ResponsePayload
    public PriceResponse decreasePrice(@RequestPayload DecreasePriceRequest request) {
        Float percent = request.getPricePercent();

        if (percent == null) {
            throw new ValidationException(
                    "Percent cannot be null",
                    new SoapErrorDto("400", "Percent cannot be null")
            );
        }

        if (percent >= 1 || percent <= 0) {
            throw new ValidationException(
                    "Decrease percentage must be less than 1 and more than 0",
                    new SoapErrorDto("400", "Decrease percentage must be less than 1 and more than 0")
            );
        }

        productsApiClient.updatePrice(1 - percent);

        return new PriceResponse("OK");
    }
}