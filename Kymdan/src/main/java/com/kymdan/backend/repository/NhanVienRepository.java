package com.kymdan.backend.repository;

import com.kymdan.backend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    NhanVien findByTen(String ten);

    NhanVien findByEmail(String email);

    @Query(value = "call thong_ke(:ngayBatDau, :ngayKetThuc)", nativeQuery = true)
    List<?> thongKe(@Param("ngayBatDau") LocalDate ngayBatDau, @Param("ngayKetThuc") LocalDate ngayKetThuc);
}
