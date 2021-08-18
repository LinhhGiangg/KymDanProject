package com.kymdan.backend.services.san_pham;

import com.kymdan.backend.entity.SanPham;
import com.kymdan.backend.model.SanPhamDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.LoaiSanPhamRepository;
import com.kymdan.backend.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

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
        String rong = thongTin.split(",")[1];
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

    @Override
    public ThongBaoDTO xoa(String ma) {
        this.sanPhamRepository.deleteById(ma);
        return new ThongBaoDTO("Xóa thành công !");
    }

    @Override
    public SanPham timBangMa(String ma) {
        return this.sanPhamRepository.findById(ma).orElse(null);
    }

    @Override
    public ThongBaoDTO sua(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = this.sanPhamRepository.findById(sanPhamDTO.getMa()).orElse(null);
        if (sanPham != null) {
            sanPham.setGia(sanPhamDTO.getGia());
            sanPham.setSoLuong(sanPhamDTO.getSoLuong());
            sanPham.setGiamGia(sanPhamDTO.getGiamGia());
            this.sanPhamRepository.save(sanPham);
            return new ThongBaoDTO("Sửa thành công !");
        } else return new ThongBaoDTO("Lỗi hệ thống ! Vui lòng thử lại sau !");
    }

    @Override
    public ThongBaoDTO taoMoi(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = new SanPham();
        sanPham.setMa(sanPhamDTO.getMa());
        sanPham.setDai("200");
        sanPham.setRong(sanPhamDTO.getKichThuoc().split("x")[0]);
        sanPham.setCao(sanPhamDTO.getDoDay());
        sanPham.setGia(sanPhamDTO.getGia());
        sanPham.setSoLuong(sanPhamDTO.getSoLuong());
        sanPham.setGiamGia(sanPhamDTO.getGiamGia());
        sanPham.setLoaiSanPham(this.loaiSanPhamRepository.findById(sanPhamDTO.getMaLoai()).orElse(null));
        this.sanPhamRepository.save(sanPham);
        return new ThongBaoDTO("Tạo mới thành công !");
    }

    @Override
    public SanPham timBangKichThuoc(SanPhamDTO sanPhamDTO) {
        List<SanPham> tatCaSanPham = this.sanPhamRepository.findAll();
        for (SanPham sanPham : tatCaSanPham) {
            if (sanPham.getLoaiSanPham().getMa().equals(sanPhamDTO.getMaLoai())
                    && sanPham.getRong().equals(sanPhamDTO.getKichThuoc().split("x")[0])
                    && sanPham.getCao().equals(sanPhamDTO.getDoDay())) {
                return sanPham;
            }
        }

        return null;
    }
}
