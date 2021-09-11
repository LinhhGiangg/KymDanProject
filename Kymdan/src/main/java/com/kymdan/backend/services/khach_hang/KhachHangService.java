package com.kymdan.backend.services.khach_hang;

import com.kymdan.backend.entity.*;
import com.kymdan.backend.model.DonHangDTO;
import com.kymdan.backend.model.ThongBaoDTO;

import java.util.List;

public interface KhachHangService {
    KhachHang timBangEmail(String email);

    KhachHang timBangTen(String ten);

    List<ChiTietGioHang> danhSachChiTietGioHang(String khachHang);

    ThongBaoDTO thayDoiSanPham(Integer maChiTiet, Integer soLuong);

    ThongBaoDTO xoaSanPham(Integer maChiTiet);

    ThongBaoDTO luuGioHang(String tenKhachHang, String maSanPham, Integer soLuong);

    ChiTietGioHang timChiTietGioHang(String maSanPham, String khachHang);

    ThongBaoDTO luuDonHang(DonHangDTO donHangDTO);

    List<DonHang> xemDonHang(String khachHang);

    List<ChiTietDonHang> xemChiTietDonHang(String maDonHang);

    ThongBaoDTO huyDonHang(String maDonHang);

    ThongBaoDTO kiemTraGioHang(String thongTin);

    List<SanPham> kiemTraSoLuongMua(String thongTin);
}
