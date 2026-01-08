package com.gabriellaureano.ecommerce.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_orderitems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    public OrderItem(Order order, Product product, Integer quantidade, BigDecimal precoUnitario) {

        if (order == null)
            throw new IllegalArgumentException("order igual a nulo");

        if (product == null)
            throw new IllegalArgumentException("produto igual a nulo");

        if (quantidade == null ||quantidade <= 0)
            throw new IllegalArgumentException("quantidade deve ser maior que zero");

        if(precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("preço deve ser maior que zero");


        this.order = order;
        this.product = product;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

}
