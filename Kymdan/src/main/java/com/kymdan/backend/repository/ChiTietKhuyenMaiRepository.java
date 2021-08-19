package com.kymdan.backend.repository;

import com.kymdan.backend.entity.ChiTietKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietKhuyenMaiRepository extends JpaRepository<ChiTietKhuyenMai, String> {
    ChiTietKhuyenMai findByKhuyenMai_Ma(String ma);
}
