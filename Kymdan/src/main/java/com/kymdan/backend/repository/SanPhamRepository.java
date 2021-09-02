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
}
