package com.sngcatering.sng_backend.controller;

import com.sngcatering.sng_backend.entity.Order;
import com.sngcatering.sng_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/{sessionId}")
    public ResponseEntity<Order> createOrder(
            @PathVariable String sessionId,
            @RequestBody Order order) {
        System.out.println("Received order: " + order);
        if ("catering".equals(order.getType()) && (order.getGuests() == null || order.getGuests() < 20)) {
            throw new IllegalArgumentException("Catering orders must be for 20 or more people");
        }
        return ResponseEntity.ok(orderService.createOrder(order, sessionId));
    }
}
