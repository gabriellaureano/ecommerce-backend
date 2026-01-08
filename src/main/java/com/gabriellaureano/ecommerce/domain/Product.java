package com.gabriellaureano.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<OrderItem> items;


    public Product(String nome, String descricao, Integer estoque, BigDecimal preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
