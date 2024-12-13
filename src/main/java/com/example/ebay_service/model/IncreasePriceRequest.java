package com.example.ebay_service.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "IncreasePriceRequest", namespace = "http://188.225.56.32:8080/ebay-service/ws")
@XmlAccessorType(XmlAccessType.FIELD)
public class IncreasePriceRequest {

    @XmlElement(name = "pricePercent", namespace = "http://188.225.56.32:8080/ebay-service/ws")
    private Float pricePercent;

    public IncreasePriceRequest() {
    }

    public IncreasePriceRequest(Float pricePercent) {
        this.pricePercent = pricePercent;
    }

    public Float getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(Float pricePercent) {
        this.pricePercent = pricePercent;
    }
}
