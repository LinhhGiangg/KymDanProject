package com.kymdan.backend.services.loai_san_pham;

import com.kymdan.backend.entity.LoaiSanPham;
import com.kymdan.backend.entity.SanPham;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.model.LoaiSanPhamDTO;
import com.kymdan.backend.repository.LoaiSanPhamRepository;
import com.kymdan.backend.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<LoaiSanPham> xemTatCa() {
        return this.loaiSanPhamRepository.findAll();
    }

    @Override
    public List<?> locTheoGia(long mucGia) {
        List<SanPham> ketQua = new ArrayList<>();
        List<SanPham> tatCaSanPham = this.sanPhamRepository.findAll();

        for (SanPham sanPham : tatCaSanPham) {
            if (mucGia == 6) {
                if (Long.parseLong(sanPham.getGia()) >= (50000000)) {
                    ketQua.add(sanPham);
                }
                continue;
            }

            if (((mucGia - 1) * 10000000) <= Long.parseLong(sanPham.getGia())
                    && Long.parseLong(sanPham.getGia()) <= (mucGia * 10000000)) {
                ketQua.add(sanPham);
            }
        }

        return ketQua;
    }

    @Override
    public LoaiSanPham timBangMaLoai(String maLoai) {
        return this.loaiSanPhamRepository.findById(maLoai).orElse(null);
    }

    @Override
    public LoaiSanPham timBangTen(String ten) {
        return this.loaiSanPhamRepository.findByTen(ten);
    }

    @Override
    public ThongBaoDTO taoMoi(LoaiSanPhamDTO loaiSanPhamDTO) {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        loaiSanPham.setMa(loaiSanPhamDTO.getMa());
        loaiSanPham.setTen(loaiSanPhamDTO.getTen());
        loaiSanPham.setMoTa(loaiSanPhamDTO.getMoTa());
        loaiSanPham.setHinh1(loaiSanPhamDTO.getHinh());
        loaiSanPham.setHinh2("assets/sanPham6.jpg");
        loaiSanPham.setHinh3("assets/sanPham7.jpg");
        loaiSanPham.setLuotXem(0);
        loaiSanPham.setNgayTao(LocalDate.now());
        this.loaiSanPhamRepository.save(loaiSanPham);

        return new ThongBaoDTO("Thêm thành công !");
    }

    @Override
    public ThongBaoDTO sua(LoaiSanPhamDTO loaiSanPhamDTO) {
        LoaiSanPham loaiSanPham = this.loaiSanPhamRepository.findByTen(loaiSanPhamDTO.getTen());
        loaiSanPham.setMoTa(loaiSanPhamDTO.getMoTa());
        loaiSanPham.setHinh1(loaiSanPhamDTO.getHinh());
        this.loaiSanPhamRepository.save(loaiSanPham);

        return new ThongBaoDTO("Sửa thành công !");
    }

    @Override
    public ThongBaoDTO xoa(String ten) {
        LoaiSanPham loaiSanPham = this.loaiSanPhamRepository.findByTen(ten);
        if (loaiSanPham.getDanhSachSanPham().size() == 0) {
            this.loaiSanPhamRepository.delete(loaiSanPham);
            return new ThongBaoDTO("Xóa thành công !");
        } else {
            return new ThongBaoDTO("Loại này có sản phẩm đang trưng bày nên không thể xóa !");
        }
    }

    @Override
    public List<LoaiSanPham> xemLoaiMoi() {
        List<LoaiSanPham> ketQua = new ArrayList<>();
        List<LoaiSanPham> tatCaLoai = this.loaiSanPhamRepository.findAll();
        LoaiSanPham loaiSanPham;
        int min;
        for (int i = 0; i < 5; i++) {
            loaiSanPham = tatCaLoai.get(0);
            min = LocalDate.now().compareTo(loaiSanPham.getNgayTao());
            for (int j = 1; j < tatCaLoai.size(); j++) {
                if (LocalDate.now().compareTo(tatCaLoai.get(j).getNgayTao()) < min) {
                    loaiSanPham = tatCaLoai.get(j);
                    min = LocalDate.now().compareTo(tatCaLoai.get(j).getNgayTao());
                }
            }
            ketQua.add(loaiSanPham);
            tatCaLoai.remove(loaiSanPham);
        }

        return ketQua;
    }

    @Override
    public List<LoaiSanPham> xemLoaiBanChay() {
        List<LoaiSanPham> ketQua = new ArrayList<>();
        List<LoaiSanPham> tatCaLoai = this.loaiSanPhamRepository.findAll();
        LoaiSanPham loaiSanPham;
        Integer max;
        for (int i = 0; i < 5; i++) {
            loaiSanPham = tatCaLoai.get(0);
            max = tatCaLoai.get(0).getLuotXem();
            for (int j = 1; j < tatCaLoai.size(); j++) {
                if (tatCaLoai.get(j).getLuotXem() > max) {
                    loaiSanPham = tatCaLoai.get(j);
                    max = tatCaLoai.get(j).getLuotXem();
                }
            }
            ketQua.add(loaiSanPham);
            tatCaLoai.remove(loaiSanPham);
        }

        return ketQua;
    }

    @Override
    public List<LoaiSanPham> timTheoTen(String ten) {
        List<LoaiSanPham> ketQua = new ArrayList<>();
        List<LoaiSanPham> tatCaLoai = this.loaiSanPhamRepository.findAll();

        for (LoaiSanPham loaiSanPham : tatCaLoai) {
            if (loaiSanPham.getTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(loaiSanPham);
            }
        }

        return ketQua;
    }

    @Override
    public ThongBaoDTO tangLuotXem(String maLoai) {
        LoaiSanPham loaiSanPham = this.loaiSanPhamRepository.findById(maLoai).orElse(null);
        if (loaiSanPham != null) {
            loaiSanPham.setLuotXem(loaiSanPham.getLuotXem() + 1);
            this.loaiSanPhamRepository.save(loaiSanPham);
        }
        return new ThongBaoDTO("OK");
    }
}
