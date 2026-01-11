package com.gabriellaureano.ecommerce.dto;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.domain.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDTO {
    private Long id;
    private LocalDateTime data;
    private OrderStatus status;
    private UserResponseDTO userResponseDTO;
    private List<OrderItemResponseDTO> items;
    private BigDecimal total;

    public OrderResponseDTO(Long id, LocalDateTime data, OrderStatus status, UserResponseDTO userResponseDTO, List<OrderItemResponseDTO> items) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.userResponseDTO = userResponseDTO;
        this.items = items;
        this.total = items.stream()
                .map(OrderItemResponseDTO::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public OrderResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public UserResponseDTO getUserResponseDTO() {
        return userResponseDTO;
    }

    public List<OrderItemResponseDTO> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
