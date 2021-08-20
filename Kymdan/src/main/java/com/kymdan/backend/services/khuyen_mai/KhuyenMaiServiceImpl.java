package com.kymdan.backend.services.khuyen_mai;

import com.kymdan.backend.entity.ChiTietKhuyenMai;
import com.kymdan.backend.entity.KhuyenMai;
import com.kymdan.backend.model.KhuyenMaiDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.ChiTietKhuyenMaiRepository;
import com.kymdan.backend.repository.KhuyenMaiRepository;
import com.kymdan.backend.repository.NhanVienRepository;
import com.kymdan.backend.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Autowired
    ChiTietKhuyenMaiRepository chiTietKhuyenMaiRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public List<KhuyenMai> xemTatCa() {
        return this.khuyenMaiRepository.findAll();
    }

    @Override
    public ThongBaoDTO taoMoi(KhuyenMaiDTO khuyenMaiDTO) {
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMa(khuyenMaiDTO.getMa());
        khuyenMai.setTen(khuyenMaiDTO.getTen());
        khuyenMai.setMoTa(khuyenMaiDTO.getMoTa());
        khuyenMai.setNgayBatDau(khuyenMaiDTO.getNgayBatDau().plusDays(1));
        khuyenMai.setNgayKetThuc(khuyenMaiDTO.getNgayKetThuc().plusDays(1));
        khuyenMai.setNhanVien(this.nhanVienRepository.findByTen(khuyenMaiDTO.getTenNhanVien()));
        this.khuyenMaiRepository.save(khuyenMai);

        ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
        chiTietKhuyenMai.setKhuyenMai(this.khuyenMaiRepository.findById(khuyenMaiDTO.getMa()).orElse(null));
        chiTietKhuyenMai.setGiamGia(khuyenMaiDTO.getGiamGia());
        chiTietKhuyenMai.setSanPham(this.sanPhamRepository.findById(khuyenMaiDTO.getMaSanPham()).orElse(null));
        this.chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);

        return new ThongBaoDTO("Tạo mới thành công !");
    }

    @Override
    public ThongBaoDTO sua(KhuyenMaiDTO khuyenMaiDTO) {
        KhuyenMai khuyenMai = this.khuyenMaiRepository.findById(khuyenMaiDTO.getMa()).orElse(null);
        if (khuyenMai != null) {
            khuyenMai.setMoTa(khuyenMaiDTO.getMoTa());
            if (khuyenMaiDTO.getTen().contains("1")) {
                khuyenMai.setNgayBatDau(khuyenMaiDTO.getNgayBatDau().plusDays(1));
            }
            if (khuyenMaiDTO.getTen().contains("2")) {
                khuyenMai.setNgayKetThuc(khuyenMaiDTO.getNgayKetThuc().plusDays(1));
            }
            khuyenMai.setNhanVien(this.nhanVienRepository.findByTen(khuyenMaiDTO.getTenNhanVien()));
            this.khuyenMaiRepository.save(khuyenMai);
        }

        ChiTietKhuyenMai chiTietKhuyenMai = this.chiTietKhuyenMaiRepository.findByKhuyenMai_Ma(khuyenMaiDTO.getMa());
        chiTietKhuyenMai.setGiamGia(khuyenMaiDTO.getGiamGia());
        this.chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);

        return new ThongBaoDTO("Sửa thành công !");
    }

    @Override
    public ThongBaoDTO xoa(String ma) {
        this.khuyenMaiRepository.deleteById(ma);
        return new ThongBaoDTO("Xóa thành công !");
    }

    @Override
    public KhuyenMai timBangMa(String ma) {
        return this.khuyenMaiRepository.findById(ma).orElse(null);
    }

    @Override
    public ChiTietKhuyenMai timChiTietBangMa(String ma) {
        return this.chiTietKhuyenMaiRepository.findByKhuyenMai_Ma(ma);
    }

    @Override
    public KhuyenMai timBangTen(String ten) {
        List<KhuyenMai> tatCaKhuyenMai = this.khuyenMaiRepository.findAll();
        for (KhuyenMai khuyenMai : tatCaKhuyenMai) {
            if (khuyenMai.getTen().equals(ten)) {
                return khuyenMai;
            }
        }
        return null;
    }
}
