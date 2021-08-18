package com.kymdan.backend.services.khach_hang;

import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public KhachHang timBangEmail(String email) {
        return this.khachHangRepository.findByEmail(email);
    }

    @Override
    public KhachHang timBangTen(String ten) {
        return this.khachHangRepository.findByTen(ten);
    }
}
