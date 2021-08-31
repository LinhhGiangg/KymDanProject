package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.DonHang;
import com.kymdan.backend.entity.NhanVienGiaoHang;
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

    @GetMapping("/phanCongGiaoHang/{thongTin}")
    public ResponseEntity<?> phanCongGiaoHang(@PathVariable String thongTin) {
        return ResponseEntity.ok(this.nhanVienService.phanCongGiaoHang(thongTin));
    }

    @GetMapping("/giaoHangHoanTat/{thongTin}")
    public ResponseEntity<?> giaoHangHoanTat(@PathVariable String thongTin) {
        return ResponseEntity.ok(this.nhanVienService.giaoHangHoanTat(thongTin));
    }
}
