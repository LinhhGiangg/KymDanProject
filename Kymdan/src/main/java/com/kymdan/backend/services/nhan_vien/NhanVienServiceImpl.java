package com.kymdan.backend.services.nhan_vien;

import com.kymdan.backend.entity.NhanVien;
import com.kymdan.backend.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public NhanVien timBangMa(String ma) {
        return this.nhanVienRepository.findById(ma).orElse(null);
    }
}
