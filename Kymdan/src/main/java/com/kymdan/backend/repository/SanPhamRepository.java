package com.kymdan.backend.repository;

import com.kymdan.backend.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, String> {
    @Query(value = "call kiem_tra_san_pham(:sanPham)", nativeQuery = true)
    List<Integer> kiemTraSanPham(@Param("sanPham") String sanPham);

    @Query(value = "select * from chi_tiet_gia\n" +
            "where ma_san_pham = ?1\n" +
            "order by ma desc limit 1", nativeQuery = true)
    Integer timGiaBangMaSanPham(String sanPham);

    @Query(value = "select * from san_pham where ma_loai_san_pham = ?1", nativeQuery = true)
    List<SanPham> locTheoMaLoai(String maLoai);

    @Query(value = "select * from san_pham\n" +
            "where ma_loai_san_pham = ?1\n" +
            "and rong = ?2\n" +
            "and cao = ?3", nativeQuery = true)
    SanPham chonSanPham(String maLoai, String rong, String cao);
}
