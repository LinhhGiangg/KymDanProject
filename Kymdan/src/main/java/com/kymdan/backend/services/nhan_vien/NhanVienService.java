package com.kymdan.backend.services.nhan_vien;

import com.kymdan.backend.entity.DonHang;
import com.kymdan.backend.entity.NhanVienGiaoHang;
import com.kymdan.backend.model.ThongBaoDTO;

import java.util.List;

public interface NhanVienService {
    List<DonHang> danhSachDonHang();

    List<NhanVienGiaoHang> danhSachNhanVienGiaoHang();

    ThongBaoDTO phanCongGiaoHang(String thongTin);

    ThongBaoDTO giaoHangHoanTat(String thongTin);
}
