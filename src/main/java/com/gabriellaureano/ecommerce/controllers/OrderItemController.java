package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.domain.OrderItem;
import com.gabriellaureano.ecommerce.dto.AddProductDTO;
import com.gabriellaureano.ecommerce.services.OrderItemService;
import jakarta.validation.Valid;
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
        public OrderItem addProduct(@PathVariable Long orderId,@Valid @RequestBody AddProductDTO addProductDTO){

        return orderItemService.adicionarProduto(orderId,addProductDTO.getProductId(), addProductDTO.getQuantidade());
    }

}
