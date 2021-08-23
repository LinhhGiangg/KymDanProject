package com.kymdan.backend.services.khach_hang;

import com.kymdan.backend.entity.ChiTietGioHang;
import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.model.ThongBaoDTO;

import java.util.List;

public interface KhachHangService {
    KhachHang timBangEmail(String email);

    KhachHang timBangTen(String ten);

    List<ChiTietGioHang> chiTietGioHang(String khachHang);

    ThongBaoDTO thayDoiSanPham(Integer maChiTiet, Integer soLuong);

    ThongBaoDTO xoaSanPham(Integer maChiTiet);

    ThongBaoDTO luuGioHang(String tenKhachHang, String maSanPham, Integer soLuong);
}
