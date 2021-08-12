package com.kymdan.backend.controllers;

import com.kymdan.backend.model.TaiKhoanDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.services.tai_khoan.TaiKhoanService;
import com.kymdan.backend.services.khach_hang.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
