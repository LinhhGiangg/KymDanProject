package com.kymdan.backend.repository;

import com.kymdan.backend.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    HoaDon findByMaSoThue(String thongTin);

    @Query(value = "select * from hoa_don order by ngay_tao desc", nativeQuery = true)
    List<HoaDon> danhSachHoaDon();
}
