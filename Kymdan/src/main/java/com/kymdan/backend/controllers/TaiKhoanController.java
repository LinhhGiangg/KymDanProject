package com.kymdan.backend.controllers;

import com.kymdan.backend.config.JwtTokenUtil;
import com.kymdan.backend.entity.TaiKhoan;
import com.kymdan.backend.model.ThongTinDTO;
import com.kymdan.backend.model.TaiKhoanHienTaiDTO;
import com.kymdan.backend.model.DangNhapDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.services.tai_khoan.TaiKhoanService;
import com.kymdan.backend.services.tai_khoan.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taiKhoan")
@CrossOrigin
public class TaiKhoanController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @RequestMapping(value = "/xacThuc", method = RequestMethod.POST)
    public ResponseEntity<?> dangNhap(@RequestBody DangNhapDTO yeuCauDangNhap) throws Exception {
        String tenDangNhap = yeuCauDangNhap.getTenDangNhap();
        String matKhau = yeuCauDangNhap.getMatKhau();
        TaiKhoan taiKhoan = taiKhoanService.timBangTenDangNhap(tenDangNhap);

        if (taiKhoan == null || !bcryptEncoder.matches(matKhau, taiKhoan.getMatKhau())) {
            return ResponseEntity.ok(new ThongBaoDTO("Thông tin đăng nhập không hợp lệ !"));
        }

        authenticate(tenDangNhap, matKhau);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(tenDangNhap);

        final String token = jwtTokenUtil.generateToken(userDetails);

        Integer ma = taiKhoan.getMa();
        String quyen = taiKhoan.getQuyen().getTen();
        String hoTen;

        switch (quyen) {
            case "Nhân Viên":
                hoTen = taiKhoan.getNhanVien().getTen();
                break;
            case "Nhân Viên Giao Hàng":
                hoTen = taiKhoan.getNhanVienGiaoHang().getTen();
                break;
            default:
                hoTen = taiKhoan.getKhachHang().getTen();
        }

        return ResponseEntity.ok(new TaiKhoanHienTaiDTO(ma, tenDangNhap, token, hoTen, quyen));
    }

    private void authenticate(String tenDangNhap, String matKhau) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tenDangNhap, matKhau));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/xemThongTin/{ten}/{quyen}")
    public ResponseEntity<?> xemThongTin(@PathVariable String ten, @PathVariable String quyen) {
        switch (quyen) {
            case "Nhân Viên":
                return new ResponseEntity<>(this.taiKhoanService.timNhanVienBangTen(ten), HttpStatus.OK);
            case "Nhân Viên Giao Hàng":
                return new ResponseEntity<>(this.taiKhoanService.timNhanVienGiaoHangBangTen(ten), HttpStatus.OK);
            default:
                return new ResponseEntity<>(this.taiKhoanService.timKhachHangBangTen(ten), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/suaThongTin")
    public ResponseEntity<?> suaThongTin(@RequestBody ThongTinDTO thongTinDTO) {
        return ResponseEntity.ok(taiKhoanService.suaThongTin(thongTinDTO));
    }

    @GetMapping("/suaMatKhau/{tenDangNhap}/{matKhauCu}/{matKhauMoi}")
    public ResponseEntity<?> editPassword(@PathVariable String tenDangNhap, @PathVariable String matKhauCu,
                                          @PathVariable String matKhauMoi) {
        return ResponseEntity.ok(taiKhoanService.suaMatKhau(tenDangNhap, matKhauCu, matKhauMoi));
    }
}
