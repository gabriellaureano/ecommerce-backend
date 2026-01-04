package com.gabriellaureano.ecommerce.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_orders")
public class Order {
    private Long id;

    private LocalDateTime data;

    private OrderStatus orderStatus;

    User user;
}
