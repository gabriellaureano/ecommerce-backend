package com.gabriellaureano.ecommerce.repositories;

import com.gabriellaureano.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
