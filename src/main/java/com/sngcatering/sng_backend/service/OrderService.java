package com.sngcatering.sng_backend.service;

import com.sngcatering.sng_backend.entity.CartItem;
import com.sngcatering.sng_backend.entity.Order;
import com.sngcatering.sng_backend.entity.OrderItem;
import com.sngcatering.sng_backend.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Transactional
    public Order createOrder(Order order, String sessionId) {
        System.out.println("Processing order with fields: " +
                "name=" + order.getName() +
                ", email=" + order.getEmail() +
                ", address=" + order.getAddress() +
                ", phone=" + order.getPhone() +
                ", type=" + order.getType() +
                ", eventDate=" + order.getEventDate() +
                ", guests=" + order.getGuests() +
                ", preferences=" + order.getPreferences());

        List<CartItem> cartItems = cartService.getCartItems(sessionId);

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setDish(cartItem.getDish());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setDishName(cartItem.getDish().getName());
            orderItem.setPrice(cartItem.getDish().getPrice());
            order.getItems().add(orderItem);

            totalPrice = totalPrice.add(
                    cartItem.getDish().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()))
            );
        }

        order.setTotalPrice(totalPrice);
        Order savedOrder = orderRepository.save(order);

        cartService.clearCart(sessionId);
        return savedOrder;
    }
}
