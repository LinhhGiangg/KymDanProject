package com.kymdan.backend.services.nhan_vien;

import com.kymdan.backend.entity.DonHang;
import com.kymdan.backend.entity.NhanVienGiaoHang;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.DonHangRepository;
import com.kymdan.backend.repository.NhanVienGiaoHangRepository;
import com.kymdan.backend.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    DonHangRepository donHangRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    NhanVienGiaoHangRepository nhanVienGiaoHangRepository;

    @Override
    public List<DonHang> danhSachDonHang() {
        return this.donHangRepository.danhSachDonHang();
    }

    @Override
    public List<NhanVienGiaoHang> danhSachNhanVienGiaoHang() {
        return this.nhanVienGiaoHangRepository.findAll();
    }

    @Override
    public ThongBaoDTO phanCongGiaoHang(String thongTin) {
        DonHang donHang = this.donHangRepository.findById(thongTin.split(",")[0]).orElse(null);
        if (donHang != null) {
            donHang.setNhanVien(this.nhanVienRepository.findByTen(thongTin.split(",")[1]));
            donHang.setNhanVienGiaoHang(this.nhanVienGiaoHangRepository.findById(thongTin.split(",")[2]).orElse(null));
            donHang.setTrangThai("Đã phân công");
            this.donHangRepository.save(donHang);
            return new ThongBaoDTO("Thành công !");
        } else return new ThongBaoDTO("Lỗi hệ thống !");
    }

    @Override
    public ThongBaoDTO giaoHangHoanTat(String thongTin) {
        DonHang donHang = this.donHangRepository.findById(thongTin).orElse(null);
        if (donHang != null) {
            donHang.setTrangThai("Hoàn tất");
            this.donHangRepository.save(donHang);
            return new ThongBaoDTO("Thành công !");
        } else return new ThongBaoDTO("Lỗi hệ thống !");
    }
}
