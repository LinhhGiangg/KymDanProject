package com.kymdan.backend.repository;

import com.kymdan.backend.entity.ChiTietKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietKhuyenMaiRepository extends JpaRepository<ChiTietKhuyenMai, Integer> {
    ChiTietKhuyenMai findByKhuyenMai_MaAndSanPham_Ma(String maKhuyenMai, String maSanPham);
}
