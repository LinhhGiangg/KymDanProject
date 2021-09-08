package com.kymdan.backend.repository;

import com.kymdan.backend.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, String> {
    @Query(value = "select * from khuyen_mai order by ngay_ket_thuc desc", nativeQuery = true)
    List<KhuyenMai> xemTatCa();
}
