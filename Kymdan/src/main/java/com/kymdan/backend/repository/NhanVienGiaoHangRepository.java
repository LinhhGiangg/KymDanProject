package com.kymdan.backend.repository;

import com.kymdan.backend.entity.NhanVienGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienGiaoHangRepository extends JpaRepository<NhanVienGiaoHang, String> {
    NhanVienGiaoHang findByTen(String ten);

    NhanVienGiaoHang findByEmail(String email);
}
