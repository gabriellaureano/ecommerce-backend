package com.gabriellaureano.ecommerce.repositories;

import com.gabriellaureano.ecommerce.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
