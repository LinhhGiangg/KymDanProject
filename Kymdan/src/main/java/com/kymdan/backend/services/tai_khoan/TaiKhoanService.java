package com.kymdan.backend.services.tai_khoan;

import com.kymdan.backend.entity.TaiKhoan;
import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.entity.NhanVien;
import com.kymdan.backend.entity.NhanVienGiaoHang;
import com.kymdan.backend.model.TaiKhoanDTO;
import com.kymdan.backend.model.ThongTinDTO;
import com.kymdan.backend.model.ThongBaoDTO;

public interface TaiKhoanService {
    ThongBaoDTO taoTaiKhoan(TaiKhoanDTO taiKhoanDTO);

    TaiKhoan timBangTenDangNhap(String tenDangNhap);

    KhachHang timKhachHangBangTen(String ten);

    NhanVien timNhanVienBangTen(String ten);

    NhanVienGiaoHang timNhanVienGiaoHangBangTen(String ten);

    ThongBaoDTO suaThongTin(ThongTinDTO thongTinDTO);

    ThongBaoDTO suaMatKhau(String tenDangNhap, String matKhauCu, String matKhauMoi);
}
