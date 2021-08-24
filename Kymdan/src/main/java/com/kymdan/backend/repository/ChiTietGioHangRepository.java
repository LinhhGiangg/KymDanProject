package com.kymdan.backend.repository;

import com.kymdan.backend.entity.ChiTietGioHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, Integer> {
    ChiTietGioHang findBySanPham_Ma(String maSanPham);
}
