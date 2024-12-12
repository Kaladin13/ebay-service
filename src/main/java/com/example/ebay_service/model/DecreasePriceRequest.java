package com.example.ebay_service.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DecreasePriceRequest", namespace = "http://example.com/price")
@XmlAccessorType(XmlAccessType.FIELD)
public class DecreasePriceRequest {

    @XmlElement(name = "pricePercent", namespace = "http://example.com/price")
    private Float pricePercent;

    public DecreasePriceRequest() {
    }

    public DecreasePriceRequest(Float pricePercent) {
        this.pricePercent = pricePercent;
    }

    public Float getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(Float pricePercent) {
        this.pricePercent = pricePercent;
    }
}