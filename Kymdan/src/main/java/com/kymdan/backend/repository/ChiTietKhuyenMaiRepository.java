package com.kymdan.backend.repository;

import com.kymdan.backend.entity.ChiTietKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietKhuyenMaiRepository extends JpaRepository<ChiTietKhuyenMai, Integer> {
    ChiTietKhuyenMai findByKhuyenMai_MaAndSanPham_Ma(String maKhuyenMai, String maSanPham);

    @Query(value = "select * from chi_tiet_khuyen_mai where ma_khuyen_mai = ?1 order by ma desc", nativeQuery = true)
    List<Integer> timBangMaKhuyenMai(String maKhuyenMai);
}
