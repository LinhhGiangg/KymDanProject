package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.ChiTietDonHang;
import com.kymdan.backend.entity.ChiTietGioHang;
import com.kymdan.backend.entity.DonHang;
import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.model.DonHangDTO;
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

    @GetMapping("/danhSachChiTietGioHang/{khachHang}")
    public ResponseEntity<List<ChiTietGioHang>> danhSachChiTietGioHang(@PathVariable String khachHang) {
        List<ChiTietGioHang> ketQua = this.khachHangService.danhSachChiTietGioHang(khachHang);
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

    @GetMapping("/timChiTietGioHang/{maSanPham}/{khachHang}")
    public ResponseEntity<ChiTietGioHang> timChiTietGioHang(@PathVariable String maSanPham,
                                                            @PathVariable String khachHang) {
        ChiTietGioHang ketQua = this.khachHangService.timChiTietGioHang(maSanPham, khachHang);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @RequestMapping(value = "/luuDonHang", method = RequestMethod.POST)
    public ResponseEntity<?> luuDonHang(@RequestBody DonHangDTO donHangDTO) {
        return ResponseEntity.ok(khachHangService.luuDonHang(donHangDTO));
    }

    @GetMapping("/xemDonHang/{khachHang}")
    public ResponseEntity<List<DonHang>> xemDonHang(@PathVariable String khachHang) {
        List<DonHang> ketQua = this.khachHangService.xemDonHang(khachHang);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/xemChiTietDonHang/{maDonHang}")
    public ResponseEntity<List<ChiTietDonHang>> xemChiTietDonHang(@PathVariable String maDonHang) {
        List<ChiTietDonHang> ketQua = this.khachHangService.xemChiTietDonHang(maDonHang);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/huyDonHang/{maDonHang}")
    public ResponseEntity<ThongBaoDTO> huyDonHang(@PathVariable String maDonHang) {
        ThongBaoDTO ketQua = this.khachHangService.huyDonHang(maDonHang);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }
}
