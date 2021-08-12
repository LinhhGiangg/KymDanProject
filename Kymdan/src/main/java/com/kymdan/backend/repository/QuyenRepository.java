package com.kymdan.backend.repository;

import com.kymdan.backend.entity.Quyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenRepository extends JpaRepository<Quyen, Integer> {
    Quyen findByTen(String ten);
}
