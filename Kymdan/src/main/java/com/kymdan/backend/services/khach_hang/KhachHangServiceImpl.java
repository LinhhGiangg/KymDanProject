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
        List<Integer> danhSachMaChiTiet;
        List<ChiTietGioHang> ketQua = new ArrayList<>();
        if (gioHang != null) {
            danhSachMaChiTiet = this.chiTietGioHangRepository.timBangMaGioHang(gioHang.getMa());
            for (Integer maChiTiet : danhSachMaChiTiet) {
                ketQua.add(this.chiTietGioHangRepository.findById(maChiTiet).orElse(null));
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
        return new ThongBaoDTO("Th??nh c??ng !");
    }

    @Override
    public ThongBaoDTO xoaSanPham(Integer maChiTiet) {
        this.chiTietGioHangRepository.deleteById(maChiTiet);
        return new ThongBaoDTO("X??a th??nh c??ng !");
    }

    @Override
    public ThongBaoDTO luuGioHang(String tenKhachHang, String maSanPham, Integer soLuong) {
        GioHang gioHang = this.gioHangRepository.findByKhachHang_Ten(tenKhachHang);
        List<Integer> danhSachMaChiTiet;
        List<ChiTietGioHang> danhSachCungGioHang = new ArrayList<>();
        boolean kiemTra = true;
        if (gioHang != null) {
            danhSachMaChiTiet = this.chiTietGioHangRepository.timBangMaGioHang(gioHang.getMa());
            for (Integer maChiTiet : danhSachMaChiTiet) {
                danhSachCungGioHang.add(this.chiTietGioHangRepository.findById(maChiTiet).orElse(null));
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

        return new ThongBaoDTO("Th??m gi??? h??ng th??nh c??ng !");
    }

    @Override
    public ChiTietGioHang timChiTietGioHang(String maSanPham, String khachHang) {
        List<Integer> danhSachMaChiTiet = this.chiTietGioHangRepository.timBangMaSanPham(maSanPham);
        ChiTietGioHang chiTietGioHang;
        for (Integer maChiTiet : danhSachMaChiTiet) {
            chiTietGioHang = this.chiTietGioHangRepository.findById(maChiTiet).orElse(null);
            if (chiTietGioHang != null && chiTietGioHang.getGioHang().getKhachHang().getTen().equals(khachHang)) {
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
        donHang.setTrangThai("Ch??? duy???t");
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

        return new ThongBaoDTO("Th??nh c??ng");
    }

    @Override
    public List<DonHang> xemDonHang(String tenKhachHang) {
        KhachHang khachHang = this.khachHangRepository.findByTen(tenKhachHang);
        return this.donHangRepository.xemDonHang(khachHang.getMa());
    }

    @Override
    public List<ChiTietDonHang> xemChiTietDonHang(String maDonHang) {
        List<Integer> danhSachMaChiTiet = this.chiTietDonHangRepository.timChiTietDonHang(maDonHang);
        List<ChiTietDonHang> ketQua = new ArrayList<>();

        for (Integer maChiTiet : danhSachMaChiTiet) {
            ketQua.add(this.chiTietDonHangRepository.findById(maChiTiet).orElse(null));
        }

        return ketQua;
    }

    @Override
    public ThongBaoDTO huyDonHang(String maDonHang) {
        List<Integer> danhSachMaChiTiet = this.chiTietDonHangRepository.timChiTietDonHang(maDonHang);
        SanPham sanPham;
        ChiTietDonHang chiTietDonHang;

        for (Integer maChiTiet : danhSachMaChiTiet) {
            chiTietDonHang = this.chiTietDonHangRepository.findById(maChiTiet).orElse(null);
            if (chiTietDonHang != null) {
                sanPham = chiTietDonHang.getSanPham();
                sanPham.setSoLuong(sanPham.getSoLuong() + chiTietDonHang.getSoLuong());
                this.sanPhamRepository.save(sanPham);
            } else return new ThongBaoDTO("L???i h??? th???ng !");
        }

        DonHang donHang = this.donHangRepository.findById(maDonHang).orElse(null);
        if (donHang != null) {
            donHang.setTrangThai("???? h???y");
            this.donHangRepository.save(donHang);
        } else return new ThongBaoDTO("L???i h??? th???ng !");

        return new ThongBaoDTO("H???y ????n h??ng th??nh c??ng");
    }

    @Override
    public ThongBaoDTO kiemTraGioHang(String thongTin) {
        for (String maChiTietGioHang : thongTin.split(",")) {
            if (this.chiTietGioHangRepository.findById(Integer.parseInt(maChiTietGioHang)).orElse(null) == null) {
                return new ThongBaoDTO("Error");
            }
        }
        return new ThongBaoDTO("OK");
    }

    @Override
    public List<SanPham> kiemTraSoLuongMua(String thongTin) {
        List<SanPham> ketQua = new ArrayList<>();
        ChiTietGioHang chiTietGioHang;
        for (String maChiTietGioHang : thongTin.split(",")) {
            chiTietGioHang = this.chiTietGioHangRepository.findById(Integer.parseInt(maChiTietGioHang)).orElse(null);
            if (chiTietGioHang != null) {
                ketQua.add(chiTietGioHang.getSanPham());
            }
        }
        return ketQua;
    }
}
