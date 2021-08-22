package com.kymdan.backend.repository;

import com.kymdan.backend.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
    GioHang findByKhachHang_Ten(String tenKhachHang);
}
