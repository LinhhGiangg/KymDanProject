package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.NhanVien;
import com.kymdan.backend.services.nhan_vien.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nhanVien")
@CrossOrigin
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/timBangMa/{ma}")
    public ResponseEntity<NhanVien> timBangMa(@PathVariable String ma) {
        NhanVien nhanVien = this.nhanVienService.timBangMa(ma);
        return new ResponseEntity<>(nhanVien, HttpStatus.OK);
    }
}
