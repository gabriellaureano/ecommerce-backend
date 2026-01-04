package com.gabriellaureano.ecommerce.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private Integer estoque;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> items;

}
