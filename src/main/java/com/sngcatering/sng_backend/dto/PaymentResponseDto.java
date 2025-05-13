package com.sngcatering.sng_backend.dto;

public class PaymentResponseDto {
    private String clientSecret;

    public PaymentResponseDto(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
