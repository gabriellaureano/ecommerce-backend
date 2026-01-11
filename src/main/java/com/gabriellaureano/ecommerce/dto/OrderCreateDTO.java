package com.gabriellaureano.ecommerce.dto;

import com.gabriellaureano.ecommerce.domain.OrderStatus;

import java.time.LocalDateTime;

public class OrderCreateDTO {
    private Long id;
    private LocalDateTime data;
    private OrderStatus status;
    private Long userId;

    public OrderCreateDTO(Long id, LocalDateTime data, OrderStatus status,Long userId) {
        this.id = id;
        this.data = data;
        this.userId = userId;
        this.status = status;
    }

    public OrderCreateDTO() {
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

    public Long getUserId() {
        return userId;
    }
}
