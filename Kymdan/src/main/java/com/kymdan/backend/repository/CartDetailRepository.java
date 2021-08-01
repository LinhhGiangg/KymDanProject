package com.kymdan.backend.repository;

import com.kymdan.backend.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
}
