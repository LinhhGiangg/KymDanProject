package com.kymdan.backend.services.khach_hang;

import com.kymdan.backend.entity.ChiTietGioHang;
import com.kymdan.backend.entity.GioHang;
import com.kymdan.backend.entity.KhachHang;
import com.kymdan.backend.model.ThongBaoDTO;
import com.kymdan.backend.repository.ChiTietGioHangRepository;
import com.kymdan.backend.repository.GioHangRepository;
import com.kymdan.backend.repository.KhachHangRepository;
import com.kymdan.backend.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public KhachHang timBangEmail(String email) {
        return this.khachHangRepository.findByEmail(email);
    }

    @Override
    public KhachHang timBangTen(String ten) {
        return this.khachHangRepository.findByTen(ten);
    }

    @Override
    public List<ChiTietGioHang> chiTietGioHang(String khachHang) {
        GioHang gioHang = this.gioHangRepository.findByKhachHang_Ten(khachHang);
        List<ChiTietGioHang> danhSach = this.chiTietGioHangRepository.findAll();
        List<ChiTietGioHang> ketQua = new ArrayList<>();

        if (gioHang != null) {
            for (ChiTietGioHang chiTietGioHang : danhSach) {
                if (chiTietGioHang.getGioHang().getMa().equals(gioHang.getMa())
                        && chiTietGioHang.getTrangThai().equals("Chưa đặt")) {
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
                    if ((chiTietGioHang.getSoLuong() + soLuong)
                            <= Integer.parseInt(chiTietGioHang.getSanPham().getSoLuong())) {
                        chiTietGioHang.setSoLuong(chiTietGioHang.getSoLuong() + soLuong);
                    } else {
                        chiTietGioHang.setSoLuong(Integer.parseInt(chiTietGioHang.getSanPham().getSoLuong()));
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
                sanPhamMoi.setTrangThai("Chưa đặt");
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
            sanPhamMoi.setTrangThai("Chưa đặt");
            this.chiTietGioHangRepository.save(sanPhamMoi);
        }

        return new ThongBaoDTO("Thêm giỏ hàng thành công !");
    }
}
