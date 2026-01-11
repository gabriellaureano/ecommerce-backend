package com.gabriellaureano.ecommerce.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProductCreateDTO {

    @NotBlank(message = "Nome invalido")
    private String nome;

    @NotBlank(message = "precisa ter uma descriçao")
    private String descricao;

    @PositiveOrZero(message = "Estoque não pode ser negativo")
    private Integer estoque;

    @DecimalMin(value = "0.0",inclusive = false,message = "Valor invalido")
    private BigDecimal preco;

    public ProductCreateDTO(String nome, String descricao, Integer estoque, BigDecimal preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
    }

    public ProductCreateDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
