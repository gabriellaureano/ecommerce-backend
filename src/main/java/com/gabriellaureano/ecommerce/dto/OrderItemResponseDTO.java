package com.gabriellaureano.ecommerce.dto;

import java.math.BigDecimal;

public class OrderItemResponseDTO {

    private Long productId;
    private String productNome;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;

    public OrderItemResponseDTO(
            Long productId,
            String productNome,
            Integer quantidade,
            BigDecimal precoUnitario
    ) {
        this.productId = productId;
        this.productNome = productNome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public Long getProductId() { return productId; }
    public String getProductNome() { return productNome; }
    public Integer getQuantidade() { return quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }
}
