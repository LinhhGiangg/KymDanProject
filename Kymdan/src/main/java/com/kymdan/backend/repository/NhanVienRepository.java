package com.kymdan.backend.repository;

import com.kymdan.backend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    NhanVien findByTen(String ten);

    NhanVien findByEmail(String email);
}
