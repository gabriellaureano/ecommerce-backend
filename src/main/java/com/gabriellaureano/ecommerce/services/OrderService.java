package com.gabriellaureano.ecommerce.services;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.domain.User;
import com.gabriellaureano.ecommerce.repositories.OrderRepository;
import com.gabriellaureano.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order criarPedido(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        Order order = new Order();

        order.setUser(user);
        order.setData(LocalDateTime.now());

        return orderRepository.save(order);
    }
}
