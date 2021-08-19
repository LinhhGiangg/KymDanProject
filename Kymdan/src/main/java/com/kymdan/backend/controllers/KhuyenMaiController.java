package com.kymdan.backend.controllers;

import com.kymdan.backend.entity.ChiTietKhuyenMai;
import com.kymdan.backend.entity.KhuyenMai;
import com.kymdan.backend.model.KhuyenMaiDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.services.khuyen_mai.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khuyenMai")
@CrossOrigin
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping("/xemTatCa")
    public ResponseEntity<List<KhuyenMai>> xemTatCa() {
        List<KhuyenMai> ketQua = this.khuyenMaiService.xemTatCa();
        return new ResponseEntity<>(ketQua, HttpStatus.OK);
    }

    @GetMapping("/timBangMa/{ma}")
    public ResponseEntity<KhuyenMai> timBangMa(@PathVariable String ma) {
        KhuyenMai khuyenMai = this.khuyenMaiService.timBangMa(ma);
        return new ResponseEntity<>(khuyenMai, HttpStatus.OK);
    }

    @GetMapping("/timChiTietBangMa/{ma}")
    public ResponseEntity<ChiTietKhuyenMai> timChiTietBangMa(@PathVariable String ma) {
        ChiTietKhuyenMai chiTietKhuyenMai = this.khuyenMaiService.timChiTietBangMa(ma);
        return new ResponseEntity<>(chiTietKhuyenMai, HttpStatus.OK);
    }

    @PostMapping(value = "/taoMoi")
    public ResponseEntity<?> taoMoi(@RequestBody KhuyenMaiDTO khuyenMaiDTO) {
        if (this.khuyenMaiService.timBangMa(khuyenMaiDTO.getMa()) != null) {
            return ResponseEntity.ok(new ThongBaoDTO("Mã " + khuyenMaiDTO.getMa() + " đã được đăng ký !"));
        } else if (this.khuyenMaiService.timBangTen(khuyenMaiDTO.getTen()) != null){
            return ResponseEntity.ok(new ThongBaoDTO("Tên " + khuyenMaiDTO.getTen() + " đã được đăng ký !"));
        } else {
            return ResponseEntity.ok(this.khuyenMaiService.taoMoi(khuyenMaiDTO));
        }
    }

    @PostMapping(value = "/sua")
    public ResponseEntity<?> sua(@RequestBody KhuyenMaiDTO khuyenMaiDTO) {
        return ResponseEntity.ok(this.khuyenMaiService.sua(khuyenMaiDTO));
    }

    @GetMapping("/xoa/{ma}")
    public ResponseEntity<?> delete(@PathVariable String ma) {
        return ResponseEntity.ok(this.khuyenMaiService.xoa(ma));
    }
}
