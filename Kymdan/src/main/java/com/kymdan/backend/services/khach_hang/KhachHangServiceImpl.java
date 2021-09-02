package com.kymdan.backend.services.khach_hang;

import com.kymdan.backend.config.TaoMaNgauNhien;
import com.kymdan.backend.entity.*;
import com.kymdan.backend.model.DonHangDTO;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private ChiTietGioHangRepository chiTietGioHangRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Override
    public KhachHang timBangEmail(String email) {
        return this.khachHangRepository.findByEmail(email);
    }

    @Override
    public KhachHang timBangTen(String ten) {
        return this.khachHangRepository.findByTen(ten);
    }

    @Override
    public List<ChiTietGioHang> danhSachChiTietGioHang(String khachHang) {
        GioHang gioHang = this.gioHangRepository.findByKhachHang_Ten(khachHang);
        List<ChiTietGioHang> danhSach = this.chiTietGioHangRepository.findAll();
        List<ChiTietGioHang> ketQua = new ArrayList<>();

        if (gioHang != null) {
            for (ChiTietGioHang chiTietGioHang : danhSach) {
                if (chiTietGioHang.getGioHang().getMa().equals(gioHang.getMa())) {
                    ketQua.add(chiTietGioHang);
                }
            }
        }

        return ketQua;
    }

    @Override
    public ThongBaoDTO thayDoiSanPham(Integer maChiTiet, Integer soLuong) {
        ChiTietGioHang chiTietGioHang = this.chiTietGioHangRepository.findById(maChiTiet).orElse(null);
        if (chiTietGioHang != null) {
            chiTietGioHang.setSoLuong(soLuong);
            this.chiTietGioHangRepository.save(chiTietGioHang);
        }
        return new ThongBaoDTO("Thành công !");
    }

    @Override
    public ThongBaoDTO xoaSanPham(Integer maChiTiet) {
        this.chiTietGioHangRepository.deleteById(maChiTiet);
        return new ThongBaoDTO("Xóa thành công !");
    }

    @Override
    public ThongBaoDTO luuGioHang(String tenKhachHang, String maSanPham, Integer soLuong) {
        GioHang gioHang = this.gioHangRepository.findByKhachHang_Ten(tenKhachHang);
        List<ChiTietGioHang> danhSachChiTiet = this.chiTietGioHangRepository.findAll();
        List<ChiTietGioHang> danhSachCungGioHang = new ArrayList<>();
        boolean kiemTra = true;
        if (gioHang != null) {
            for (ChiTietGioHang chiTietGioHang : danhSachChiTiet) {
                if (chiTietGioHang.getGioHang().getMa().equals(gioHang.getMa())) {
                    danhSachCungGioHang.add(chiTietGioHang);
                }
            }

            for (ChiTietGioHang chiTietGioHang : danhSachCungGioHang) {
                if (chiTietGioHang.getSanPham().getMa().equals(maSanPham)) {
                    if ((chiTietGioHang.getSoLuong() + soLuong) <= chiTietGioHang.getSanPham().getSoLuong()) {
                        chiTietGioHang.setSoLuong(chiTietGioHang.getSoLuong() + soLuong);
                    } else {
                        chiTietGioHang.setSoLuong(chiTietGioHang.getSanPham().getSoLuong());
                    }
                    this.chiTietGioHangRepository.save(chiTietGioHang);
                    kiemTra = false;
                    break;
                }
            }

            if (kiemTra) {
                ChiTietGioHang sanPhamMoi = new ChiTietGioHang();
                sanPhamMoi.setGioHang(gioHang);
                sanPhamMoi.setSanPham(this.sanPhamRepository.findById(maSanPham).orElse(null));
                sanPhamMoi.setSoLuong(soLuong);
                this.chiTietGioHangRepository.save(sanPhamMoi);
            }
        } else {
            GioHang gioHangMoi = new GioHang();
            gioHangMoi.setKhachHang(this.khachHangRepository.findByTen(tenKhachHang));
            this.gioHangRepository.save(gioHangMoi);

            ChiTietGioHang sanPhamMoi = new ChiTietGioHang();
            sanPhamMoi.setGioHang(this.gioHangRepository.findByKhachHang_Ten(tenKhachHang));
            sanPhamMoi.setSanPham(this.sanPhamRepository.findById(maSanPham).orElse(null));
            sanPhamMoi.setSoLuong(soLuong);
            this.chiTietGioHangRepository.save(sanPhamMoi);
        }

        return new ThongBaoDTO("Thêm giỏ hàng thành công !");
    }

    @Override
    public ChiTietGioHang timChiTietGioHang(String maSanPham, String khachHang) {
        List<ChiTietGioHang> danhSachGioHang = this.chiTietGioHangRepository.findAll();
        for (ChiTietGioHang chiTietGioHang : danhSachGioHang) {
            if (chiTietGioHang.getGioHang().getKhachHang().getTen().equals(khachHang)
                    && chiTietGioHang.getSanPham().getMa().equals(maSanPham)) {
                return chiTietGioHang;
            }
        }
        return null;
    }

    @Override
    public ThongBaoDTO luuDonHang(DonHangDTO donHangDTO) {
        GioHang gioHang = this.gioHangRepository.findByKhachHang_Ten(donHangDTO.getKhachHang());

        DonHang donHang = new DonHang();
        String maDonHang;
        do {
            maDonHang = "DH" + TaoMaNgauNhien.tao(8);
        } while (this.donHangRepository.findById(maDonHang).orElse(null) != null);
        donHang.setMa(maDonHang);
        donHang.setNguoiNhan(donHangDTO.getNguoiNhan());
        donHang.setDiaChi(donHangDTO.getDiaChi());
        donHang.setSoDienThoai(donHangDTO.getSoDienThoai());
        donHang.setNgayDat(LocalDate.now());
        donHang.setNgayNhan(donHangDTO.getNgayNhan().plusDays(1));
        donHang.setTrangThai("Chờ duyệt");
        donHang.setCachThanhToan(donHangDTO.getCachThanhToan());
        donHang.setKhachHang(this.khachHangRepository.findByTen(donHangDTO.getKhachHang()));
        this.donHangRepository.save(donHang);

        for (int i = 0; i < donHangDTO.getSanPham().split(",").length; i++) {
            ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
            chiTietDonHang.setDonHang(this.donHangRepository.findById(maDonHang).orElse(null));
            chiTietDonHang.setSoLuong(Integer.parseInt(donHangDTO.getSoLuong().split(",")[i]));
            chiTietDonHang.setGia(Integer.parseInt(donHangDTO.getGia().split(",")[i]));
            chiTietDonHang.setSanPham(this.sanPhamRepository
                    .findById(donHangDTO.getSanPham().split(",")[i]).orElse(null));
            this.chiTietDonHangRepository.save(chiTietDonHang);

            SanPham sanPham = this.sanPhamRepository.findById(donHangDTO.getSanPham().split(",")[i]).orElse(null);
            if (sanPham != null) {
                sanPham.setSoLuong(sanPham.getSoLuong() - Integer.parseInt(donHangDTO.getSoLuong().split(",")[i]));
                this.sanPhamRepository.save(sanPham);
            }

            List<ChiTietGioHang> danhSachGioHang = this.chiTietGioHangRepository.findAll();
            for (ChiTietGioHang chiTietGioHang : danhSachGioHang) {
                if (chiTietGioHang.getGioHang().getMa().equals(gioHang.getMa())
                        && chiTietGioHang.getSanPham().getMa().equals(donHangDTO.getSanPham().split(",")[i])) {
                    this.chiTietGioHangRepository.delete(chiTietGioHang);
                } else {
                    if (chiTietGioHang.getSanPham().getMa().equals(donHangDTO.getSanPham().split(",")[i])) {
                        if (chiTietGioHang.getSanPham().getSoLuong().equals(0)) {
                            this.chiTietGioHangRepository.delete(chiTietGioHang);
                        } else {
                            if (chiTietGioHang.getSoLuong() > chiTietGioHang.getSanPham().getSoLuong()) {
                                chiTietGioHang.setSoLuong(chiTietGioHang.getSanPham().getSoLuong());
                            }
                        }
                    }
                }
            }
        }

        return new ThongBaoDTO("Thành công");
    }

    @Override
    public List<DonHang> xemDonHang(String tenKhachHang) {
        KhachHang khachHang = this.khachHangRepository.findByTen(tenKhachHang);
        return this.donHangRepository.xemDonHang(khachHang.getMa());
    }

    @Override
    public List<ChiTietDonHang> xemChiTietDonHang(String maDonHang) {
        List<ChiTietDonHang> danhSachChiTiet = this.chiTietDonHangRepository.findAll();
        List<ChiTietDonHang> ketQua = new ArrayList<>();

        for (ChiTietDonHang chiTietDonHang : danhSachChiTiet) {
            if (chiTietDonHang.getDonHang().getMa().equals(maDonHang)) {
                ketQua.add(chiTietDonHang);
            }
        }

        return ketQua;
    }
}
