package com.kymdan.backend.services.san_pham;

import com.kymdan.backend.entity.SanPham;
import com.kymdan.backend.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> timBangMaLoai(String maLoai) {
        List<SanPham> sanPhamCanTim = new ArrayList<>();
        List<SanPham> tatCaSanPham = this.sanPhamRepository.findAll();

        for (SanPham sanPham : tatCaSanPham) {
            if (sanPham.getLoaiSanPham().getMa().equals(maLoai)) {
                sanPhamCanTim.add(sanPham);
            }
        }

        return sanPhamCanTim;
    }
}
