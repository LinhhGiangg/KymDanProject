package com.kymdan.backend.repository;

import com.kymdan.backend.entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, Integer> {
    @Query(value = "call loc_chi_tiet_don_hang()", nativeQuery = true)
    List<ChiTietDonHang> locChiTietDonHang();

    @Query(value = "select * from chi_tiet_don_hang where ma_don_hang = ?1", nativeQuery = true)
    List<Integer> timChiTietDonHang(String maDonHang);
}
