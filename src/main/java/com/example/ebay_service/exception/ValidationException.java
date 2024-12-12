package com.example.ebay_service.exception;

public class ValidationException extends RuntimeException {

    private SoapErrorDto soapErrorDto;

    public ValidationException(String message, SoapErrorDto soapErrorDto) {
        super(message);
        this.soapErrorDto = soapErrorDto;
    }

    public ValidationException(String message, Throwable e, SoapErrorDto soapErrorDto) {
        super(message, e);
        this.soapErrorDto = soapErrorDto;
    }

    public SoapErrorDto getServiceFault() {
        return soapErrorDto;
    }

    public void setServiceFault(SoapErrorDto soapErrorDto) {
        this.soapErrorDto = soapErrorDto;
    }
}
