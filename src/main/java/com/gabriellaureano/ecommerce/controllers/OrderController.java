package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.dto.OrderCreateDTO;
import com.gabriellaureano.ecommerce.dto.OrderResponseDTO;
import com.gabriellaureano.ecommerce.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // CRIA O PEDIDO PRO USUARIO DE ACORDO COM O USERID PASSADO NA ROTA
    @PostMapping("/user/{userId}")
    public OrderCreateDTO criarPedido(@PathVariable Long userId){
        return orderService.criarPedido(userId);
    }

    // BUSCA PEDIDO PELO ID PASSADO NA ROTA
    @GetMapping("/{Id}")
    public OrderResponseDTO buscarPedido(@PathVariable Long Id){
        return orderService.buscarpedido(Id);
    }

    //  BUSCA TODOS OS PEDIDOS
    @GetMapping
    public List<OrderResponseDTO> buscarTodosPedidos(){
        return orderService.buscarTodosPedidos();
    }
}
