package com.kymdan.backend.services.nhan_vien;

import com.kymdan.backend.entity.DonHang;
import com.kymdan.backend.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    DonHangRepository donHangRepository;

    @Override
    public List<DonHang> danhSachDonHang() {
        return this.donHangRepository.findAll();
    }
}
