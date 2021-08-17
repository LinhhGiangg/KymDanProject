package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.SanPham;
import com.kymdan.backend.model.SanPhamDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.services.san_pham.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanPham")
@CrossOrigin
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/locTheoMaLoai/{maLoai}")
    public ResponseEntity<List<SanPham>> locTheoMaLoai(@PathVariable String maLoai) {
        List<SanPham> ketQua = this.sanPhamService.locTheoMaLoai(maLoai);
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/sanPhamDauTien/{thongTin}")
    public ResponseEntity<SanPham> sanPhamDauTien(@PathVariable String thongTin) {
        SanPham sanPham = this.sanPhamService.sanPhamDauTien(thongTin);
        return new ResponseEntity<>(sanPham, HttpStatus.OK);
    }

    @GetMapping("/chonSanPham/{thongTin}")
    public ResponseEntity<SanPham> chonSanPham(@PathVariable String thongTin) {
        SanPham sanPham = this.sanPhamService.chonSanPham(thongTin);
        return new ResponseEntity<>(sanPham, HttpStatus.OK);
    }

    @GetMapping("/xoa/{ma}")
    public ResponseEntity<?> xoaSanPham(@PathVariable String ma) {
        return ResponseEntity.ok(this.sanPhamService.xoa(ma));
    }

    @GetMapping("/timBangMa/{ma}")
    public ResponseEntity<SanPham> timBangMa(@PathVariable String ma) {
        SanPham sanPham = this.sanPhamService.timBangMa(ma);
        return new ResponseEntity<>(sanPham, HttpStatus.OK);
    }

    @PostMapping(value = "/sua")
    public ResponseEntity<?> sua(@RequestBody SanPhamDTO sanPhamDTO) {
        return ResponseEntity.ok(this.sanPhamService.sua(sanPhamDTO));
    }

    @PostMapping(value = "/taoMoi")
    public ResponseEntity<?> taoMoi(@RequestBody SanPhamDTO sanPhamDTO) {
        if (this.sanPhamService.timBangMa(sanPhamDTO.getMa()) != null) {
            return ResponseEntity.ok(new ThongBaoDTO("Mã " + sanPhamDTO.getMa() + " đã được đăng ký !"));
        } else if (this.sanPhamService.timBangKichThuoc(sanPhamDTO) != null){
            return ResponseEntity.ok(this.sanPhamService.timBangKichThuoc(sanPhamDTO));
        } else {
            return ResponseEntity.ok(this.sanPhamService.taoMoi(sanPhamDTO));
        }
    }
}
