package com.kymdan.backend.services.san_pham;

import com.kymdan.backend.entity.SanPham;
import com.kymdan.backend.model.SanPhamDTO;
import com.kymdan.backend.model.ThongBaoDTO;

import java.util.List;

public interface SanPhamService {
    List<SanPham> locTheoMaLoai(String maLoai);

    SanPham sanPhamDauTien(String thongTin);

    SanPham chonSanPham(String thongTin);

    ThongBaoDTO xoa(String ma);

    SanPham timBangMa(String ma);

    ThongBaoDTO sua(SanPhamDTO sanPhamDTO);

    ThongBaoDTO taoMoi(SanPhamDTO sanPhamDTO);

    ThongBaoDTO timBangKichThuoc(SanPhamDTO sanPhamDTO);
}
