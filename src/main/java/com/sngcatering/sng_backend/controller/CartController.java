package com.sngcatering.sng_backend.controller;

import com.sngcatering.sng_backend.entity.CartItem;
import com.sngcatering.sng_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{sessionId}")
    @Cacheable(value = "cartItems", key = "#sessionId")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable String sessionId) {
        return ResponseEntity.ok(cartService.getCartItems(sessionId));
    }

    @PostMapping("/{sessionId}/add")
    public ResponseEntity<CartItem> addToCart(
            @PathVariable String sessionId,
            @RequestParam Long dishId,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(cartService.addToCart(sessionId, dishId, quantity));
    }

    @PutMapping("/{sessionId}/update")
    public ResponseEntity<CartItem> updateQuantity(
            @PathVariable String sessionId,
            @RequestParam Long dishId,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(cartService.updateQuantity(sessionId, dishId, quantity));
    }

    @DeleteMapping("/{sessionId}/remove")
    public ResponseEntity<Void> removeFromCart(
            @PathVariable String sessionId,
            @RequestParam Long dishId) {
        cartService.removeFromCart(sessionId, dishId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{sessionId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable String sessionId) {
        cartService.clearCart(sessionId);
        return ResponseEntity.ok().build();
    }
}
