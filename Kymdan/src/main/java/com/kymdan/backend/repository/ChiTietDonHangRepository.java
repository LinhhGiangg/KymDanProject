package com.kymdan.backend.repository;

import com.kymdan.backend.entity.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHang, Integer> {
    @Query(value = "call loc_chi_tiet()", nativeQuery = true)
    List<ChiTietDonHang> locChiTiet();
}
