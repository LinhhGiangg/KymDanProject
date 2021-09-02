package com.kymdan.backend.services.khuyen_mai;

import com.kymdan.backend.entity.ChiTietKhuyenMai;
import com.kymdan.backend.entity.KhuyenMai;
import com.kymdan.backend.entity.SanPham;
import com.kymdan.backend.model.KhuyenMaiDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.ChiTietKhuyenMaiRepository;
import com.kymdan.backend.repository.KhuyenMaiRepository;
import com.kymdan.backend.repository.NhanVienRepository;
import com.kymdan.backend.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        List<KhuyenMai> tatCa = this.khuyenMaiRepository.findAll();
        List<KhuyenMai> ketQua = new ArrayList<>();

        for (int i = 0; i < tatCa.size(); ) {
            KhuyenMai khuyenMai = tatCa.get(0);
            LocalDate moiNhat = khuyenMai.getNgayKetThuc();
            for (KhuyenMai phanTu : tatCa) {
                if (phanTu.getNgayKetThuc().isAfter(moiNhat)) {
                    khuyenMai = phanTu;
                    moiNhat = phanTu.getNgayKetThuc();
                }
            }
            ketQua.add(khuyenMai);
            tatCa.remove(khuyenMai);
        }

        return ketQua;
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
    public KhuyenMai timBangTen(String ten) {
        List<KhuyenMai> tatCaKhuyenMai = this.khuyenMaiRepository.findAll();
        for (KhuyenMai khuyenMai : tatCaKhuyenMai) {
            if (khuyenMai.getTen().equals(ten)) {
                return khuyenMai;
            }
        }
        return null;
    }

    @Override
    public List<ChiTietKhuyenMai> timChiTietBangMaKhuyenMai(String maKhuyenMai) {
        List<ChiTietKhuyenMai> tatCa = this.chiTietKhuyenMaiRepository.findAll();
        List<ChiTietKhuyenMai> ketQua = new ArrayList<>();
        for (ChiTietKhuyenMai chiTietKhuyenMai : tatCa) {
            if (chiTietKhuyenMai.getKhuyenMai().getMa().equals(maKhuyenMai)) {
                ketQua.add(chiTietKhuyenMai);
            }
        }
        return ketQua;
    }

    @Override
    public ThongBaoDTO themSanPhamKhuyenMai(String maKhuyenMai, String maSanPham, Integer giamGia) {
        SanPham sanPham = this.sanPhamRepository.findById(maSanPham).orElse(null);
        if (sanPham == null) {
            return new ThongBaoDTO("Sản phẩm này không tồn tại !");
        } else if (sanPham.getSoLuong().equals(0)) {
            return new ThongBaoDTO("Sản phẩm này đã hết hàng !");
        } else if (this.chiTietKhuyenMaiRepository.findByKhuyenMai_MaAndSanPham_Ma(maKhuyenMai, maSanPham) != null) {
            return new ThongBaoDTO("Sản phẩm này đã có trong đợt khuyến mãi !");
        } else {
            ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
            chiTietKhuyenMai.setKhuyenMai(this.khuyenMaiRepository.findById(maKhuyenMai).orElse(null));
            chiTietKhuyenMai.setSanPham(sanPham);
            chiTietKhuyenMai.setGiamGia(giamGia);
            this.chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
            return new ThongBaoDTO("Thêm sản phẩm khuyến mãi thành công !");
        }
    }

    @Override
    public ThongBaoDTO suaSanPhamKhuyenMai(Integer maChiTiet, Integer giamGia) {
        ChiTietKhuyenMai chiTietKhuyenMai = this.chiTietKhuyenMaiRepository.findById(maChiTiet).orElse(null);
        if (chiTietKhuyenMai != null) {
            chiTietKhuyenMai.setGiamGia(giamGia);
            this.chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
            return new ThongBaoDTO("Sửa thành công !");
        }
        return new ThongBaoDTO("Lỗi hệ thống !");
    }

    @Override
    public ThongBaoDTO xoaSanPhamKhuyenMai(Integer maChiTiet) {
        this.chiTietKhuyenMaiRepository.deleteById(maChiTiet);
        return new ThongBaoDTO("Xóa thành công !");
    }
}
