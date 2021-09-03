package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.DonHang;
import com.kymdan.backend.entity.NhanVienGiaoHang;
import com.kymdan.backend.model.HoaDonDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.services.nhan_vien.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nhanVien")
@CrossOrigin
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/danhSachDonHang/{nhanVien}")
    public ResponseEntity<List<DonHang>> danhSachDonHang() {
        List<DonHang> ketQua = this.nhanVienService.danhSachDonHang();
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/danhSachNhanVienGiaoHang/{nhanVien}")
    public ResponseEntity<List<NhanVienGiaoHang>> danhSachNhanVienGiaoHang() {
        List<NhanVienGiaoHang> ketQua = this.nhanVienService.danhSachNhanVienGiaoHang();
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/giaoHangHoanTat/{thongTin}")
    public ResponseEntity<?> giaoHangHoanTat(@PathVariable String thongTin) {
        return ResponseEntity.ok(this.nhanVienService.giaoHangHoanTat(thongTin));
    }

    @GetMapping("/thongKe/{nhanVien}")
    public ResponseEntity<List<?>> thongKe() {
        List<?> ketQua = this.nhanVienService.thongKe();
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @PostMapping(value = "/phanCongGiaoHang")
    public ResponseEntity<?> phanCongGiaoHang(@RequestBody HoaDonDTO hoaDonDTO) {
        if (nhanVienService.timHoaDonBangMaHoaDon(hoaDonDTO.getMaHoaDon()) != null) {
            return ResponseEntity.ok(new ThongBaoDTO("Mã hóa đơn này đã được đăng kí !"));
        } else if (nhanVienService.timHoaDonBangMaSoThue(hoaDonDTO.getMaSoThue()) != null) {
            return ResponseEntity.ok(new ThongBaoDTO("Mã số thuế này đã có hóa đơn !"));
        } else {
            return ResponseEntity.ok(this.nhanVienService.phanCongGiaoHang(hoaDonDTO));
        }
    }
}
