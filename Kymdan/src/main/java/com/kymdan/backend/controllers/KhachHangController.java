package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.ChiTietGioHang;
import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.entity.LoaiSanPham;
import com.kymdan.backend.model.TaiKhoanDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.services.tai_khoan.TaiKhoanService;
import com.kymdan.backend.services.khach_hang.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khachHang")
@CrossOrigin
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @RequestMapping(value = "/dangKy", method = RequestMethod.POST)
    public ResponseEntity<?> dangKyKhachHangMoi(@RequestBody TaiKhoanDTO taiKhoanDTO) {
        if (taiKhoanService.timBangTenDangNhap(taiKhoanDTO.getTenDangNhap()) != null) {
            return ResponseEntity.ok
                    (new ThongBaoDTO("Tên đăng nhập này đã được đăng kí ! Vui lòng điền tên đăng nhập khác !"));
        } else if (khachHangService.timBangEmail(taiKhoanDTO.getThongTinDTO().getEmail()) != null) {
            return ResponseEntity.ok(new ThongBaoDTO("Email này đã được đăng kí ! Vui lòng nhập email khác !"));
        } else {
            return ResponseEntity.ok(taiKhoanService.taoTaiKhoan(taiKhoanDTO));
        }
    }

    @GetMapping("/timBangTen/{ten}")
    public ResponseEntity<KhachHang> timBangTen(@PathVariable String ten) {
        KhachHang khachHang = this.khachHangService.timBangTen(ten);
        return new ResponseEntity<>(khachHang, HttpStatus.OK);
    }

    @GetMapping("/chiTietGioHang/{khachHang}")
    public ResponseEntity<List<ChiTietGioHang>> chiTietGioHang(@PathVariable String khachHang) {
        List<ChiTietGioHang> ketQua = this.khachHangService.chiTietGioHang(khachHang);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/thayDoiSanPham/{maChiTiet}/{soLuong}")
    public ResponseEntity<ThongBaoDTO> thayDoiSanPham(@PathVariable Integer maChiTiet, @PathVariable Integer soLuong) {
        return ResponseEntity.ok(khachHangService.thayDoiSanPham(maChiTiet, soLuong));
    }

    @GetMapping("/xoaSanPham/{maChiTiet}")
    public ResponseEntity<ThongBaoDTO> xoaSanPham(@PathVariable Integer maChiTiet) {
        return ResponseEntity.ok(khachHangService.xoaSanPham(maChiTiet));
    }

    @GetMapping("/luuGioHang/{tenKhachHang}/{maSanPham}/{soLuong}")
    public ResponseEntity<ThongBaoDTO> luuGioHang(@PathVariable String tenKhachHang, @PathVariable String maSanPham,
                                                  @PathVariable Integer soLuong) {
        return ResponseEntity.ok(khachHangService.luuGioHang(tenKhachHang, maSanPham, soLuong));
    }
}
