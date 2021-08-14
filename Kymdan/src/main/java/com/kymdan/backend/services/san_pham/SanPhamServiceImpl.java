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
    public List<SanPham> locTheoMaLoai(String maLoai) {
        List<SanPham> tatCaSanPham = this.sanPhamRepository.findAll();
        List<SanPham> ketQua = new ArrayList<>();

        for (SanPham sanPham : tatCaSanPham) {
            if (sanPham.getLoaiSanPham().getMa().equals(maLoai)) {
                ketQua.add(sanPham);
            }
        }

        return ketQua;
    }

    @Override
    public SanPham sanPhamDauTien(String thongTin) {
        List<SanPham> tatCaSanPham = this.sanPhamRepository.findAll();
        List<SanPham> cungLoai = new ArrayList<>();
        SanPham ketQua = null;
        String maLoai = thongTin.split(",")[0];

        for (SanPham sanPham : tatCaSanPham) {
            if (sanPham.getLoaiSanPham().getMa().equals(maLoai)) {
                cungLoai.add(sanPham);
                if (sanPham.getRong().equals("120") && sanPham.getCao().equals("5")) {
                    ketQua = sanPham;
                }
            }
        }

        if (ketQua == null && cungLoai.size() != 0) {
            ketQua = cungLoai.get(0);
            long giaThapNhat = Long.parseLong(ketQua.getGia());
            for (SanPham sanPham : cungLoai) {
                if (Long.parseLong(ketQua.getGia()) < giaThapNhat) {
                    giaThapNhat = Long.parseLong(ketQua.getGia());
                    ketQua = sanPham;
                }
            }
        }

        return ketQua;
    }

    @Override
    public SanPham chonSanPham(String thongTin) {
        List<SanPham> tatCaSanPham = this.sanPhamRepository.findAll();
        String maLoai = thongTin.split(",")[0];
        String rong = thongTin.split(",")[1].split("x")[0];
        String cao = thongTin.split(",")[2];

        for (SanPham sanPham : tatCaSanPham) {
            if (sanPham.getLoaiSanPham().getMa().equals(maLoai)
                    && sanPham.getRong().equals(rong)
                    && sanPham.getCao().equals(cao)) {
                return sanPham;
            }
        }

        return null;
    }
}
