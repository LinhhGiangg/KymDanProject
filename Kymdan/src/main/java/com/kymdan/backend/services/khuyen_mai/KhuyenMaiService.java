package com.kymdan.backend.services.khuyen_mai;

import com.kymdan.backend.entity.ChiTietKhuyenMai;
import com.kymdan.backend.entity.KhuyenMai;
import com.kymdan.backend.model.KhuyenMaiDTO;
import com.kymdan.backend.model.ThongBaoDTO;

import java.util.List;

public interface KhuyenMaiService {
    List<KhuyenMai> xemTatCa();

    ThongBaoDTO taoMoi(KhuyenMaiDTO khuyenMaiDTO);

    ThongBaoDTO sua(KhuyenMaiDTO khuyenMaiDTO);

    ThongBaoDTO xoa(String ma);

    KhuyenMai timBangMa(String ma);

    KhuyenMai timBangTen(String ten);

    List<ChiTietKhuyenMai> timChiTietBangMaKhuyenMai(String maKhuyenMai);

    ThongBaoDTO themSanPhamKhuyenMai(String maKhuyenMai, String maSanPham, Integer giamGia);

    ThongBaoDTO suaSanPhamKhuyenMai(Integer maChiTiet, Integer giamGia);

    ThongBaoDTO xoaSanPhamKhuyenMai(Integer maChiTiet);
}
