package com.example.ebay_service.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "IncreasePriceRequest", namespace = "http://example.com/price")
@XmlAccessorType(XmlAccessType.FIELD)
public class IncreasePriceRequest {

    @XmlElement(name = "pricePercent", namespace = "http://example.com/price")
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
