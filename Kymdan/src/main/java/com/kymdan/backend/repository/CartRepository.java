package com.kymdan.backend.repository;

import com.kymdan.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByAppAccount_Username(String userName);
}
