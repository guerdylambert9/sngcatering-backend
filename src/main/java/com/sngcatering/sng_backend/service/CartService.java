package com.sngcatering.sng_backend.service;

import com.sngcatering.sng_backend.entity.CartItem;
import com.sngcatering.sng_backend.entity.Dish;
import com.sngcatering.sng_backend.repository.CartItemRepository;
import com.sngcatering.sng_backend.repository.DishRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private DishRepository dishRepository;
     public List<CartItem> getCartItems(String sessionId) {
         return cartItemRepository.findBySessionId(sessionId);
     }

    @Transactional
    public CartItem addToCart(String sessionId, Long dishId, Integer quantity) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        CartItem cartItem = new CartItem();
        cartItem.setSessionId(sessionId);
        cartItem.setDish(dish);
        cartItem.setQuantity(quantity);

        return cartItemRepository.save(cartItem);
    }

    @Transactional
    public CartItem updateQuantity(String sessionId, Long dishId, Integer quantity) {
        CartItem cartItem = cartItemRepository.findBySessionId(sessionId).stream()
                .filter(item -> item.getDish().getId().equals(dishId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    @Transactional
    public void removeFromCart(String sessionId, Long dishId) {
        CartItem cartItem = cartItemRepository.findBySessionId(sessionId).stream()
                .filter(item -> item.getDish().getId().equals(dishId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cartItemRepository.delete(cartItem);
    }

    @Transactional
    public void clearCart(String sessionId) {
        cartItemRepository.deleteBySessionId(sessionId);
    }
}
