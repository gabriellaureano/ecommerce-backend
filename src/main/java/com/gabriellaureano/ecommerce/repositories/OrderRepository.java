package com.gabriellaureano.ecommerce.repositories;

import com.gabriellaureano.ecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
