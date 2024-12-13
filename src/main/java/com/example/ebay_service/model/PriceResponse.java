package com.example.ebay_service.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PriceResponse", namespace = "http://188.225.56.32:8080/ebay-service/ws")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceResponse {

    @XmlElement(name = "message", namespace = "http://188.225.56.32:8080/ebay-service/ws")
    private String message;

    public PriceResponse() {
    }

    public PriceResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
