package com.kymdan.backend.services.san_pham;

import com.kymdan.backend.entity.ChiTietGia;
import com.kymdan.backend.entity.ChiTietKhuyenMai;
import com.kymdan.backend.entity.SanPham;
import com.kymdan.backend.model.SanPhamDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Autowired
    private ChiTietGiaRepository chiTietGiaRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private ChiTietKhuyenMaiRepository chiTietKhuyenMaiRepository;

    @Override
    public List<SanPham> locTheoMaLoai(String maLoai) {
        return this.sanPhamRepository.locTheoMaLoai(maLoai);
    }

    @Override
    public SanPham sanPhamDauTien(String thongTin) {
        List<SanPham> tatCaSanPham = this.sanPhamRepository.findAll();
        List<SanPham> cungLoai = new ArrayList<>();
        SanPham ketQua = null;
        String maLoai = thongTin.split(",")[0];

        for (SanPham sanPham : tatCaSanPham) {
            if (sanPham.getLoaiSanPham().getMa().equals(maLoai) && (sanPham.getSoLuong() > 0)) {
                cungLoai.add(sanPham);
                if (sanPham.getRong().equals("120") && sanPham.getCao().equals("5")) {
                    ketQua = sanPham;
                }
            }
        }


        if (ketQua == null || (ketQua.getSoLuong() <= 0)) {
            ketQua = cungLoai.get(0);
            long rongNhoNhat = Long.parseLong(ketQua.getRong());
            for (SanPham sanPham : cungLoai) {
                if (Long.parseLong(ketQua.getRong()) < rongNhoNhat) {
                    rongNhoNhat = Long.parseLong(ketQua.getRong());
                    ketQua = sanPham;
                }
            }
        }

        return ketQua;
    }

    @Override
    public SanPham chonSanPham(String thongTin) {
        String maLoai = thongTin.split(",")[0];
        String rong = thongTin.split(",")[1];
        String cao = thongTin.split(",")[2];

        return this.sanPhamRepository.chonSanPham(maLoai, rong, cao);
    }

    @Override
    public ThongBaoDTO xoa(String ma) {
        List<Integer> danhSach = this.sanPhamRepository.kiemTraSanPham(ma);
        if (danhSach.size() == 0) {
            this.sanPhamRepository.deleteById(ma);
            return new ThongBaoDTO("X??a th??nh c??ng !");
        } else {
            return new ThongBaoDTO("S???n ph???m n??y ???? ???????c mua n??n kh??ng th??? x??a !");
        }
    }

    @Override
    public SanPham timBangMa(String ma) {
        return this.sanPhamRepository.findById(ma).orElse(null);
    }

    @Override
    public ThongBaoDTO sua(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = this.sanPhamRepository.findById(sanPhamDTO.getMa()).orElse(null);
        if (sanPham != null) {
            ChiTietGia chiTietGia = new ChiTietGia();
            chiTietGia.setSanPham(sanPham);
            chiTietGia.setGia(sanPhamDTO.getGia());
            chiTietGia.setNgayThayDoi(LocalDate.now());
            chiTietGia.setNhanVien(this.nhanVienRepository.findByTen(sanPhamDTO.getNhanVien()));
            this.chiTietGiaRepository.save(chiTietGia);

            sanPham.setSoLuong(sanPhamDTO.getSoLuong());
            this.sanPhamRepository.save(sanPham);

            return new ThongBaoDTO("S???a th??nh c??ng !");
        } else return new ThongBaoDTO("L???i h??? th???ng ! Vui l??ng th??? l???i sau !");
    }

    @Override
    public ThongBaoDTO taoMoi(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = new SanPham();
        sanPham.setMa(sanPhamDTO.getMa());
        sanPham.setDai("200");
        sanPham.setRong(sanPhamDTO.getKichThuoc().split("x")[0]);
        sanPham.setCao(sanPhamDTO.getDoDay());
        sanPham.setSoLuong(sanPhamDTO.getSoLuong());
        sanPham.setLoaiSanPham(this.loaiSanPhamRepository.findById(sanPhamDTO.getMaLoai()).orElse(null));
        this.sanPhamRepository.save(sanPham);

        ChiTietGia chiTietGia = new ChiTietGia();
        chiTietGia.setSanPham(this.sanPhamRepository.findById(sanPhamDTO.getMa()).orElse(null));
        chiTietGia.setGia(sanPhamDTO.getGia());
        chiTietGia.setNgayThayDoi(LocalDate.now());
        chiTietGia.setNhanVien(this.nhanVienRepository.findByTen(sanPhamDTO.getNhanVien()));
        this.chiTietGiaRepository.save(chiTietGia);

        return new ThongBaoDTO("T???o m???i th??nh c??ng !");
    }

    @Override
    public SanPham timBangKichThuoc(SanPhamDTO sanPhamDTO) {
        String maLoai = sanPhamDTO.getMaLoai();
        String rong = sanPhamDTO.getKichThuoc().split("x")[0];
        String cao = sanPhamDTO.getDoDay();

        return this.sanPhamRepository.chonSanPham(maLoai, rong, cao);
    }

    @Override
    public ChiTietGia timGiaBangMaSanPham(String ma) {
        Integer maChiTietGia = this.sanPhamRepository.timGiaBangMaSanPham(ma);
        return this.chiTietGiaRepository.findById(maChiTietGia).orElse(null);
    }

    @Override
    public ChiTietKhuyenMai timKhuyenMaiBangMaSanPham(String ma) {
        List<ChiTietKhuyenMai> danhSach = this.chiTietKhuyenMaiRepository.findAll();
        List<ChiTietKhuyenMai> danhSachCungSanPham = new ArrayList<>();
        ChiTietKhuyenMai ketQua = null;

        for (ChiTietKhuyenMai chiTietKhuyenMai : danhSach) {
            if (chiTietKhuyenMai.getSanPham().getMa().equals(ma)) {
                danhSachCungSanPham.add(chiTietKhuyenMai);
            }
        }

        for (ChiTietKhuyenMai chiTietKhuyenMai : danhSachCungSanPham) {
            if (LocalDate.now().isBefore(chiTietKhuyenMai.getKhuyenMai().getNgayKetThuc())
                    && LocalDate.now().isAfter(chiTietKhuyenMai.getKhuyenMai().getNgayBatDau())
                    || LocalDate.now().equals(chiTietKhuyenMai.getKhuyenMai().getNgayBatDau())
                    || LocalDate.now().equals(chiTietKhuyenMai.getKhuyenMai().getNgayKetThuc())) {
                ketQua = chiTietKhuyenMai;
                break;
            }
        }

        return ketQua;
    }

    @Override
    public List<SanPham> sanPhamTon() {
        return this.sanPhamRepository.sanPhamTon();
    }
}
