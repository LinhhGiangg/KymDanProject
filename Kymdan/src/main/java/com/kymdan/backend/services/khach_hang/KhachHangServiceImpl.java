package com.kymdan.backend.services.khach_hang;

import com.kymdan.backend.entity.ChiTietGioHang;
import com.kymdan.backend.entity.GioHang;
import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.repository.ChiTietGioHangRepository;
import com.kymdan.backend.repository.GioHangRepository;
import com.kymdan.backend.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private ChiTietGioHangRepository chiTietGioHangRepository;

    @Override
    public KhachHang timBangEmail(String email) {
        return this.khachHangRepository.findByEmail(email);
    }

    @Override
    public KhachHang timBangTen(String ten) {
        return this.khachHangRepository.findByTen(ten);
    }

    @Override
    public List<ChiTietGioHang> chiTietGioHang(String khachHang) {
        GioHang gioHang = this.gioHangRepository.findByKhachHang_Ten(khachHang);
        List<ChiTietGioHang> danhSach = this.chiTietGioHangRepository.findAll();
        List<ChiTietGioHang> ketQua = new ArrayList<>();

        if (gioHang != null) {
            for (ChiTietGioHang chiTietGioHang : danhSach) {
                if (chiTietGioHang.getGioHang().getMa().equals(gioHang.getMa())) {
                    ketQua.add(chiTietGioHang);
                }
            }
        }

        return ketQua;
    }
}
