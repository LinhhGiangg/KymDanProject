package com.kymdan.backend.repository;

import com.kymdan.backend.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
    GioHang findByKhachHang_Ten(String tenKhachHang);

    @Query(value = "select * from chi_tiet_gio_hang where ma_gio_hang = ?1", nativeQuery = true)
    List<Integer> danhSachChiTietGioHang(Integer gioHang);
}
