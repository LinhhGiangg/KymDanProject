package com.kymdan.backend.services.loai_san_pham;

import com.kymdan.backend.entity.ChiTietDonHang;
import com.kymdan.backend.entity.LoaiSanPham;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.model.LoaiSanPhamDTO;
import com.kymdan.backend.repository.ChiTietDonHangRepository;
import com.kymdan.backend.repository.LoaiSanPhamRepository;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
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
    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Override
    public List<LoaiSanPham> xemTatCa() {
        return this.loaiSanPhamRepository.xemTatCa();
    }

    @Override
    public List<?> locTheoGia(long mucGia) {
        return this.loaiSanPhamRepository.findAll();
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
        loaiSanPham.setLuongMua(0);
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
            return new ThongBaoDTO("Loại này đang có sản phẩm trưng bày nên không thể xóa !");
        }
    }

    @Override
    public List<LoaiSanPham> xemLoaiMoi() {
        return this.loaiSanPhamRepository.xemLoaiMoi();
    }

    @Override
    public List<LoaiSanPham> xemLoaiBanChay() {
        List<LoaiSanPham> ketQua = new ArrayList<>();
        List<LoaiSanPham> locDanhSach = new ArrayList<>();
        List<ChiTietDonHang> danhSachMua = this.chiTietDonHangRepository.locChiTietDonHang();
        List<ChiTietDonHang> mangTam = new ArrayList<>();
        LoaiSanPham loaiSanPham;
        int luongMua;
        int soDem = 0;

        for (; danhSachMua.size() > 0; ) {
            loaiSanPham = danhSachMua.get(0).getSanPham().getLoaiSanPham();
            loaiSanPham.setLuongMua(danhSachMua.get(0).getSoLuong());
            for (int i = 1; i < danhSachMua.size(); i++) {
                if (danhSachMua.get(i).getSanPham().getLoaiSanPham().getMa().equals(loaiSanPham.getMa())) {
                    loaiSanPham.setLuongMua(loaiSanPham.getLuongMua() + danhSachMua.get(i).getSoLuong());
                    mangTam.add(danhSachMua.get(i));
                }
            }
            for (ChiTietDonHang phanTu : mangTam) {
                danhSachMua.remove(phanTu);
            }
            locDanhSach.add(loaiSanPham);
            danhSachMua.remove(danhSachMua.get(0));
        }

        for (; locDanhSach.size() > 0 && soDem < 5; ) {
            loaiSanPham = locDanhSach.get(0);
            luongMua = loaiSanPham.getLuongMua();
            for (LoaiSanPham sanPham : locDanhSach) {
                if (sanPham.getLuongMua() > luongMua) {
                    loaiSanPham = sanPham;
                    luongMua = sanPham.getLuongMua();
                }
            }
            ketQua.add(loaiSanPham);
            soDem += 1;
            locDanhSach.remove(loaiSanPham);
        }

        return ketQua;
    }

    @Override
    public List<LoaiSanPham> locTheoTen(String kiTu) {
        kiTu = kiTu.trim().toLowerCase();
        kiTu = kiTu.replaceAll("\\s+", " ");
        return this.loaiSanPhamRepository.locTheoTen(kiTu);
    }
}
