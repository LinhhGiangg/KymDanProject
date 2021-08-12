package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.SanPham;
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

    @GetMapping("/timBangMaLoai/{maLoai}")
    public ResponseEntity<List<SanPham>> timBangMaLoai(@PathVariable String maLoai) {
        List<SanPham> danhSachSanPham = this.sanPhamService.timBangMaLoai(maLoai);
        return new ResponseEntity<>(danhSachSanPham, HttpStatus.OK);
    }
}
