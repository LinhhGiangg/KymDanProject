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
import java.time.Period;
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

//        for (SanPham sanPham : tatCaSanPham) {
//            if (mucGia == 6) {
//                if (Long.parseLong(sanPham.getGia()) >= (50000000)) {
//                    ketQua.add(sanPham);
//                }
//                continue;
//            }
//
//            if (((mucGia - 1) * 10000000) <= Long.parseLong(sanPham.getGia())
//                    && Long.parseLong(sanPham.getGia()) <= (mucGia * 10000000)) {
//                ketQua.add(sanPham);
//            }
//        }

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
        loaiSanPham.setLuotMua(0);
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
        LocalDate ngayHienTai = LocalDate.now();
        List<LoaiSanPham> ketQua = new ArrayList<>();
        List<LoaiSanPham> loaiMoiNhap = new ArrayList<>();
        List<LoaiSanPham> tatCaLoai = this.loaiSanPhamRepository.findAll();
        LoaiSanPham loaiSanPham;
        int ngayGanNhat;
        int soDem = 0;

        for (LoaiSanPham phanTu : tatCaLoai) {
            Period soNgay = Period.between(phanTu.getNgayTao(), ngayHienTai);
            if (soNgay.getDays() < 31 && soNgay.getMonths() == 0 && soNgay.getYears() == 0) {
                loaiMoiNhap.add(phanTu);
            }
        }

        for (int i = 0; i < loaiMoiNhap.size() && soDem < 5;) {
            loaiSanPham = loaiMoiNhap.get(0);
            ngayGanNhat = LocalDate.now().compareTo(loaiSanPham.getNgayTao());
            for (LoaiSanPham sanPham : loaiMoiNhap) {
                if (LocalDate.now().compareTo(sanPham.getNgayTao()) < ngayGanNhat) {
                    loaiSanPham = sanPham;
                    ngayGanNhat = LocalDate.now().compareTo(sanPham.getNgayTao());
                }
            }
            ketQua.add(loaiSanPham);
            soDem += 1;
            loaiMoiNhap.remove(loaiSanPham);
        }

        return ketQua;
    }

    @Override
    public List<LoaiSanPham> xemLoaiBanChay() {
        List<LoaiSanPham> ketQua = new ArrayList<>();
        List<LoaiSanPham> loaiDaMua = new ArrayList<>();
        List<LoaiSanPham> tatCaLoai = this.loaiSanPhamRepository.findAll();
        LoaiSanPham loaiSanPham;
        int luotMua;
        int soDem = 0;

        for (LoaiSanPham phanTu : tatCaLoai) {
            if (phanTu.getLuotMua() > 0) {
                loaiDaMua.add(phanTu);
            }
        }

        for (; loaiDaMua.size() > 0 && soDem < 5;) {
            loaiSanPham = loaiDaMua.get(0);
            luotMua = loaiSanPham.getLuotMua();
            for (LoaiSanPham sanPham : loaiDaMua) {
                if (sanPham.getLuotMua() > luotMua) {
                    loaiSanPham = sanPham;
                    luotMua = sanPham.getLuotMua();
                }
            }
            ketQua.add(loaiSanPham);
            soDem += 1;
            loaiDaMua.remove(loaiSanPham);
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
