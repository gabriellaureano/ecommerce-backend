package com.gabriellaureano.ecommerce.services;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.domain.OrderItem;
import com.gabriellaureano.ecommerce.domain.OrderStatus;
import com.gabriellaureano.ecommerce.domain.User;
import com.gabriellaureano.ecommerce.dto.OrderCreateDTO;
import com.gabriellaureano.ecommerce.dto.OrderItemResponseDTO;
import com.gabriellaureano.ecommerce.dto.OrderResponseDTO;
import com.gabriellaureano.ecommerce.dto.UserResponseDTO;
import com.gabriellaureano.ecommerce.repositories.OrderRepository;
import com.gabriellaureano.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public OrderCreateDTO criarPedido(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        Order order = new Order();

        order.setUser(user);
        order.setData(LocalDateTime.now());

        orderRepository.save(order);

        OrderCreateDTO orderCreateDTO = new OrderCreateDTO(
                order.getId(),
                order.getData(),
                order.getStatus(),
                order.getUser().getId()
        );
        return orderCreateDTO;
    }

    public OrderResponseDTO buscarpedido(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido nao encontrado"));

        User user = order.getUser();

        List<OrderItemResponseDTO> itemsDto = order.getItems().stream()
                .map(item -> new OrderItemResponseDTO(
                        item.getProduct().getId(),
                        item.getProduct().getNome(),
                        item.getQuantidade(),
                        item.getPrecoUnitario()
                ))
                .toList();

        return new OrderResponseDTO(
                order.getId(),
                order.getData(),
                order.getStatus(),
                new UserResponseDTO(
                        user.getId(),
                        user.getNome(),
                        user.getEmail()
                ),
                itemsDto
        );

    }

    public List<OrderResponseDTO> buscarTodosPedidos(){
        List<Order> pedidosCriados = orderRepository.findAll().stream()
                .filter(p -> p.getStatus() == OrderStatus.CRIADO)
                .toList();


        List<OrderResponseDTO> pedidosConvertidos = pedidosCriados.stream()
                .map( pedido -> {

                    List<OrderItemResponseDTO> itemsdto = pedido.getItems().stream()
                            .map(item -> new OrderItemResponseDTO(
                                    item.getProduct().getId(),
                                    item.getProduct().getNome(),
                                    item.getQuantidade(),
                                    item.getPrecoUnitario()
                            ))
                            .toList();

                    UserResponseDTO userDto = new UserResponseDTO(
                            pedido.getUser().getId(),
                            pedido.getUser().getNome(),
                            pedido.getUser().getEmail()
                    );

                    return new OrderResponseDTO(
                            pedido.getId(),
                            pedido.getData(),
                            pedido.getStatus(),
                            userDto,
                            itemsdto
                    );
                })
                .toList();

        return pedidosConvertidos;
    }

}
