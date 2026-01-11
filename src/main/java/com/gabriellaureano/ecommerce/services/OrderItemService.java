package com.gabriellaureano.ecommerce.services;

import com.gabriellaureano.ecommerce.domain.Order;
import com.gabriellaureano.ecommerce.domain.OrderItem;
import com.gabriellaureano.ecommerce.domain.Product;
import com.gabriellaureano.ecommerce.repositories.OrderItemRepository;
import com.gabriellaureano.ecommerce.repositories.OrderRepository;
import com.gabriellaureano.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderRepository orderRepository,ProductRepository productRepository,OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem adicionarProduto(Long orderId,Long productId,Integer quantidade){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("pedido não encontrado"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("produto com id: " + productId + " não foi encontrado"));

        if (quantidade <= 0){
            throw new RuntimeException("Sem estoque no momento");
        }

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantidade(quantidade);
        item.setPrecoUnitario(product.getPreco());

        order.addItem(item);

        orderItemRepository.save(item);
        orderRepository.save(order);

        return item;
    }
}
