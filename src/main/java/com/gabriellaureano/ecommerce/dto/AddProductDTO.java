package com.gabriellaureano.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddProductDTO {

    @NotNull(message = "ProductId é obrigatorio")
    private Long productId;

    @NotNull(message = "Quantidade é obrigatorio")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    public AddProductDTO(Long productId, Integer estoque) {
        this.productId = productId;
        this.quantidade = quantidade;
    }

    public AddProductDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
