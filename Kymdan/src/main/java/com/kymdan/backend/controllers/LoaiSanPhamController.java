package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.LoaiSanPham;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.model.LoaiSanPhamDTO;
import com.kymdan.backend.services.loai_san_pham.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaiSanPham")
@CrossOrigin
public class LoaiSanPhamController {
    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping("/xemTatCa")
    public ResponseEntity<List<LoaiSanPham>> xemTatCa() {
        List<LoaiSanPham> ketQua = this.loaiSanPhamService.xemTatCa();
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/locTheoGia/{gia}")
    public ResponseEntity<List<?>> locTheoGia(@PathVariable long gia) {
        List<?> ketQua = this.loaiSanPhamService.locTheoGia(gia);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/timBangMaLoai/{maLoai}")
    public ResponseEntity<LoaiSanPham> timBangMaLoai(@PathVariable String maLoai) {
        LoaiSanPham loaiSanPham = this.loaiSanPhamService.timBangMaLoai(maLoai);
        return new ResponseEntity<>(loaiSanPham, HttpStatus.OK);
    }

    @PostMapping(value = "/taoMoi")
    public ResponseEntity<?> taoMoi(@RequestBody LoaiSanPhamDTO loaiSanPhamDTO) {
        if (this.loaiSanPhamService.timBangMaLoai(loaiSanPhamDTO.getMa()) != null) {
            return ResponseEntity.ok(new ThongBaoDTO("Mã " + loaiSanPhamDTO.getMa() + " đã được đăng ký !"));
        } else if (this.loaiSanPhamService.timBangTen(loaiSanPhamDTO.getTen()) != null){
            return ResponseEntity.ok(new ThongBaoDTO("Tên " + loaiSanPhamDTO.getTen() + " đã được đăng ký !"));
        } else {
            return ResponseEntity.ok(this.loaiSanPhamService.taoMoi(loaiSanPhamDTO));
        }
    }

    @PostMapping(value = "/sua")
    public ResponseEntity<?> sua(@RequestBody LoaiSanPhamDTO loaiSanPhamDTO) {
        return ResponseEntity.ok(this.loaiSanPhamService.sua(loaiSanPhamDTO));
    }

    @GetMapping("/xoa/{ten}")
    public ResponseEntity<?> xoa(@PathVariable String ten) {
        return ResponseEntity.ok(this.loaiSanPhamService.xoa(ten));
    }

    @GetMapping("/xemLoaiMoi")
    public ResponseEntity<List<LoaiSanPham>> xemLoaiMoi() {
        List<LoaiSanPham> ketQua = this.loaiSanPhamService.xemLoaiMoi();
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/xemLoaiBanChay")
    public ResponseEntity<List<LoaiSanPham>> xemLoaiBanChay() {
        List<LoaiSanPham> ketQua = this.loaiSanPhamService.xemLoaiBanChay();
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/locTheoTen/{kiTu}")
    public ResponseEntity<List<LoaiSanPham>> locTheoTen(@PathVariable String kiTu) {
        List<LoaiSanPham> ketQua = this.loaiSanPhamService.locTheoTen(kiTu);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }
}
