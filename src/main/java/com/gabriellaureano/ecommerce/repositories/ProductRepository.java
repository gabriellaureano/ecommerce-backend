package com.gabriellaureano.ecommerce.repositories;

import com.gabriellaureano.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
