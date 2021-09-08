package com.kymdan.backend.repository;

import com.kymdan.backend.entity.ChiTietGioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, Integer> {
    @Query(value = "select * from chi_tiet_gio_hang where ma_gio_hang = ?1", nativeQuery = true)
    List<Integer> timBangMaGioHang(Integer gioHang);

    @Query(value = "select * from chi_tiet_gio_hang where ma_san_pham = ?1", nativeQuery = true)
    List<Integer> timBangMaSanPham(String maSanPham);
}
