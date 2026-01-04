package com.gabriellaureano.ecommerce.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_orders")
public class Order {
    private Long id;

    private LocalDateTime data;

    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
