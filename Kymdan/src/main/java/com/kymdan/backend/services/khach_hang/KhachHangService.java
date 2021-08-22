package com.kymdan.backend.services.khach_hang;

import com.kymdan.backend.entity.ChiTietGioHang;
import com.kymdan.backend.entity.KhachHang;

import java.util.List;

public interface KhachHangService {
    KhachHang timBangEmail(String email);

    KhachHang timBangTen(String ten);

    List<ChiTietGioHang> chiTietGioHang(String khachHang);
}
