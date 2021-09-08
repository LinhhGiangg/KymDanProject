package com.kymdan.backend.repository;

import com.kymdan.backend.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonHangRepository extends JpaRepository<DonHang, String> {
    @Query(value = "select * from don_hang \n" +
            "where ma_khach_hang = ?1 \n" +
            "order by ngay_dat desc;", nativeQuery = true)
    List<DonHang> xemDonHang(Integer maKhachHang);

    @Query(value = "select * from don_hang order by ngay_dat desc", nativeQuery = true)
    List<DonHang> danhSachDonHang();
}
