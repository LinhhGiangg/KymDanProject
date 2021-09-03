package com.kymdan.backend.repository;

import com.kymdan.backend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    NhanVien findByTen(String ten);

    NhanVien findByEmail(String email);

    @Query(value = "call thong_ke()", nativeQuery = true)
    List<?> thongKe();
}
