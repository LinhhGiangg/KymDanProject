package com.kymdan.backend.services.nhan_vien;

import com.kymdan.backend.entity.ChiTietDonHang;
import com.kymdan.backend.entity.DonHang;
import com.kymdan.backend.entity.HoaDon;
import com.kymdan.backend.entity.NhanVienGiaoHang;
import com.kymdan.backend.model.HoaDonDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    DonHangRepository donHangRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    NhanVienGiaoHangRepository nhanVienGiaoHangRepository;

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    ChiTietDonHangRepository chiTietDonHangRepository;

    @Override
    public List<DonHang> danhSachDonHang() {
        return this.donHangRepository.danhSachDonHang();
    }

    @Override
    public List<NhanVienGiaoHang> danhSachNhanVienGiaoHang() {
        return this.nhanVienGiaoHangRepository.findAll();
    }

    @Override
    public ThongBaoDTO phanCongGiaoHang(HoaDonDTO hoaDonDTO) {
        int tongTien = 0;
        ChiTietDonHang chiTietDonHang;
        DonHang donHang = this.donHangRepository.findById(hoaDonDTO.getDonHang()).orElse(null);
        if (donHang != null) {
            donHang.setNhanVien(this.nhanVienRepository.findByTen(hoaDonDTO.getNhanVien()));
            donHang.setNhanVienGiaoHang(this.nhanVienGiaoHangRepository.findById(hoaDonDTO.getGiaoHang()).orElse(null));
            donHang.setTrangThai("Đã phân công");
            this.donHangRepository.save(donHang);

            HoaDon hoaDon = new HoaDon();
            hoaDon.setMa(hoaDonDTO.getMaHoaDon());
            hoaDon.setMaSoThue(hoaDonDTO.getMaSoThue());
            hoaDon.setNgayTao(LocalDate.now());

            List<Integer> danhSach = this.donHangRepository.timChiTietDonHang(donHang.getMa());
            for (Integer maChiTiet : danhSach) {
                chiTietDonHang = this.chiTietDonHangRepository.findById(maChiTiet).orElse(null);
                if (chiTietDonHang != null) {
                    tongTien += chiTietDonHang.getGia() * chiTietDonHang.getSoLuong();
                }
            }
            hoaDon.setTongTien(tongTien);

            hoaDon.setDonHang(donHang);
            hoaDon.setNhanVien(this.nhanVienRepository.findByTen(hoaDonDTO.getNhanVien()));
            this.hoaDonRepository.save(hoaDon);

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

    @Override
    public List<?> thongKe() {
        return this.nhanVienRepository.thongKe();
    }

    @Override
    public HoaDon timHoaDonBangMaHoaDon(String thongTin) {
        return this.hoaDonRepository.findById(thongTin).orElse(null);
    }

    @Override
    public HoaDon timHoaDonBangMaSoThue(String thongTin) {
        return this.hoaDonRepository.findByMaSoThue(thongTin);
    }
}
