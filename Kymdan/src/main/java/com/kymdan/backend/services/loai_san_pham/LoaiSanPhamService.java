package com.kymdan.backend.services.loai_san_pham;

import com.kymdan.backend.entity.LoaiSanPham;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.model.LoaiSanPhamDTO;

import java.util.List;

public interface LoaiSanPhamService {
    List<LoaiSanPham> xemTatCa();

    List<?> locTheoGia(long mucGia);

    LoaiSanPham timBangMaLoai(String maLoai);

    LoaiSanPham timBangTen(String ten);

    ThongBaoDTO taoMoi(LoaiSanPhamDTO loaiSanPhamDTO);

    ThongBaoDTO sua(LoaiSanPhamDTO loaiSanPhamDTO);

    ThongBaoDTO xoa(String ten);

    List<LoaiSanPham> xemLoaiMoi();

    List<LoaiSanPham> xemLoaiBanChay();

    List<LoaiSanPham> timTheoTen(String ten);
}
