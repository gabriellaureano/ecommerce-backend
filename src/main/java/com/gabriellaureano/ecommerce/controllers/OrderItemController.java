package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.domain.OrderItem;
import com.gabriellaureano.ecommerce.services.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/orders/{orderId}/item")
        public OrderItem addProduct(@PathVariable Long orderId, @RequestBody Map<String,Integer> body){

        Long produtId = body.get("productId").longValue();
        Integer quantidade = body.get("quantidade");

        return orderItemService.adicionarProduto(orderId,produtId,quantidade);
    }

}
