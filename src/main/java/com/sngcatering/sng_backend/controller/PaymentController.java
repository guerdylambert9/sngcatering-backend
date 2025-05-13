package com.sngcatering.sng_backend.controller;

import com.sngcatering.sng_backend.dto.ErrorResponseDto;
import com.sngcatering.sng_backend.dto.PaymentRequestDto;
import com.sngcatering.sng_backend.dto.PaymentResponseDto;
import com.sngcatering.sng_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public ResponseEntity<?> createPaymentIntent(@RequestBody PaymentRequestDto paymentRequestDto) {
        try {
            String clientSecret = paymentService.createPaymentIntent(
                    paymentRequestDto.getAmount(),
                    paymentRequestDto.getCurrency(),
                    paymentRequestDto.getSessionId()
            );
            return ResponseEntity.ok(new PaymentResponseDto(clientSecret));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ErrorResponseDto("Failed to create payment intent: " + e.getMessage()));
        }
    }
}
