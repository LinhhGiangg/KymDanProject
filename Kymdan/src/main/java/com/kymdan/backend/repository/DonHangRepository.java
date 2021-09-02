package com.kymdan.backend.repository;

import com.kymdan.backend.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonHangRepository extends JpaRepository<DonHang, String> {
    @Query(value = "call xem_don_hang(:maKhachHang)", nativeQuery = true)
    List<DonHang> xemDonHang(@Param("maKhachHang") Integer maKhachHang);

    @Query(value = "select * from don_hang order by ngay_dat desc", nativeQuery = true)
    List<DonHang> danhSachDonHang();
}
