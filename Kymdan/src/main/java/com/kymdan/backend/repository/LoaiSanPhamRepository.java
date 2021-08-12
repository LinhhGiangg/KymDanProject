package com.kymdan.backend.repository;

import com.kymdan.backend.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, String> {
    LoaiSanPham findByTen (String ten);
}
