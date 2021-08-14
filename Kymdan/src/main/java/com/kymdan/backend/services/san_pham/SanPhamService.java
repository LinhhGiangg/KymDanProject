package com.kymdan.backend.services.san_pham;

import com.kymdan.backend.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> locTheoMaLoai(String maLoai);

    SanPham sanPhamDauTien(String thongTin);

    SanPham chonSanPham(String thongTin);
}
