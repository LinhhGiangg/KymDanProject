package com.kymdan.backend.repository;

import com.kymdan.backend.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, String> {
    LoaiSanPham findByTen(String ten);

    @Query(value = "select * from loai_san_pham order by ngay_tao desc", nativeQuery = true)
    List<LoaiSanPham> xemTatCa();

    @Query(value = "call xem_loai_moi()", nativeQuery = true)
    List<LoaiSanPham> xemLoaiMoi();
}
