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
        if ("regular".equals(order.getType())) {
            if (order.getName() == null || order.getEmail() == null ||
                    order.getAddress() == null || order.getPhone() == null) {
                throw new IllegalArgumentException("Name, email, address, and phone are required for regular orders");
            }
        } else if ("catering".equals(order.getType())) {
            if (order.getName() == null || order.getEmail() == null ||
                    order.getPhone() == null || order.getEventDate() == null ||
                    order.getGuests() == null) {
                throw new IllegalArgumentException("Name, email, phone, event date, and guests are required for catering orders");
            }
            if (order.getGuests() < 20) {
                throw new IllegalArgumentException("Catering orders must be for 20 or more people");
            }
        } else {
            throw new IllegalArgumentException("Invalid order type: " + order.getType());
        }
        Order savedOrder = orderService.createOrder(order, sessionId);
        System.out.println("Returning saved order: " + savedOrder);
        return ResponseEntity.ok(savedOrder);
    }
}









//package com.sngcatering.sng_backend.controller;
//
//import com.sngcatering.sng_backend.entity.Order;
//import com.sngcatering.sng_backend.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/orders")
//@CrossOrigin(origins = "*")
//public class OrderController {
//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping("/{sessionId}")
//    public ResponseEntity<Order> createOrder(
//            @PathVariable String sessionId,
//            @RequestBody Order order) {
//        System.out.println("Received order: " + order);
//        if ("catering".equals(order.getType()) && (order.getGuests() == null || order.getGuests() < 20)) {
//            throw new IllegalArgumentException("Catering orders must be for 20 or more people");
//        }
//        return ResponseEntity.ok(orderService.createOrder(order, sessionId));
//    }
//}
