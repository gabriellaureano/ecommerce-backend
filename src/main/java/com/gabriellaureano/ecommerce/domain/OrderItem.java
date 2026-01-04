package com.gabriellaureano.ecommerce.domain;

import java.math.BigDecimal;

public class OrderItem {
    private Long id;

    private Integer quantidade;

    private BigDecimal precoUnitario;

    Order order;

    Product product;

}
