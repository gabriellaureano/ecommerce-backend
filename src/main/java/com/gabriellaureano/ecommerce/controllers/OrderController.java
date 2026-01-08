package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.services.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/user/{userId}")
    public Order criarPedido(@PathVariable Long userId){
        return orderService.criarPedido(userId);
    }

}
