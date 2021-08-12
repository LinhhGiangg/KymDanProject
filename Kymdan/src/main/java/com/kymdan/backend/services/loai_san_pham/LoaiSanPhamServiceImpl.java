package com.kymdan.backend.services.loai_san_pham;

import com.kymdan.backend.entity.LoaiSanPham;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.model.LoaiSanPhamDTO;
import com.kymdan.backend.repository.LoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Override
    public List<LoaiSanPham> xemTatCa() {
        return this.loaiSanPhamRepository.findAll();
    }

    @Override
    public List<LoaiSanPham> locTheoGia(long mucGia) {
        List<LoaiSanPham> ketQua = new ArrayList<>();
        List<LoaiSanPham> tatCaLoai = this.loaiSanPhamRepository.findAll();

//        if (mucGia == 7) {
//            ketQua = tatCaLoai;
//        } else {
//            for (LoaiSanPham loaiSanPham : tatCaLoai) {
//                if (mucGia == 6) {
//                    if (Long.parseLong(loaiSanPham.getPrice()) >= (50000000)) {
//                        result.add(loaiSanPham);
//                    }
//                    continue;
//                }
//
//                if (((price - 1) * 10000000) <= Long.parseLong(loaiSanPham.getPrice())
//                        && Long.parseLong(loaiSanPham.getPrice()) <= (price * 10000000)) {
//                    result.add(loaiSanPham);
//                }
//            }
//        }

        return tatCaLoai;
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
}
