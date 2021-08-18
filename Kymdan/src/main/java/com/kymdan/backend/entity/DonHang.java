package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "nguoi_nhan", columnDefinition = "VARCHAR(50)")
    private String nguoiNhan;

    @Column(name = "dia_chi", columnDefinition = "VARCHAR(250)")
    private String diaChi;

    @Column(name = "so_dien_thoai", columnDefinition = "VARCHAR(20)")
    private String soDienThoai;

    @Column(name = "ngay_dat", columnDefinition = "DATE")
    private LocalDate ngayDat;

    @Column(name = "ngay_nhan", columnDefinition = "DATE")
    private LocalDate ngayNhan;

    @Column(name = "trang_thai", columnDefinition = "VARCHAR(50)")
    private String trangThai;

    @Column(name = "cach_thanh_toan", columnDefinition = "VARCHAR(50)")
    private String cachThanhToan;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private NhanVien nhanVien;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma", columnDefinition = "INT")
    private KhachHang khachHang;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietDonHang> danhSachChiTietDonHang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_nhan_vien_giao_hang", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private NhanVienGiaoHang nhanVienGiaoHang;

    @OneToOne
    @JoinColumn(name = "ma_hoa_don", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private HoaDon hoaDon;

    public DonHang() {
    }

    public DonHang(Integer ma, String nguoiNhan, String diaChi, String soDienThoai, LocalDate ngayDat,
                   LocalDate ngayNhan, String trangThai, String cachThanhToan, NhanVien nhanVien,
                   KhachHang khachHang, List<ChiTietDonHang> danhSachChiTietDonHang, NhanVienGiaoHang nhanVienGiaoHang,
                   HoaDon hoaDon) {
        this.ma = ma;
        this.nguoiNhan = nguoiNhan;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngayDat = ngayDat;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
        this.cachThanhToan = cachThanhToan;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.danhSachChiTietDonHang = danhSachChiTietDonHang;
        this.nhanVienGiaoHang = nhanVienGiaoHang;
        this.hoaDon = hoaDon;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getCachThanhToan() {
        return cachThanhToan;
    }

    public void setCachThanhToan(String cachThanhToan) {
        this.cachThanhToan = cachThanhToan;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public List<ChiTietDonHang> getDanhSachChiTietDonHang() {
        return danhSachChiTietDonHang;
    }

    public void setDanhSachChiTietDonHang(List<ChiTietDonHang> danhSachChiTietDonHang) {
        this.danhSachChiTietDonHang = danhSachChiTietDonHang;
    }

    public NhanVienGiaoHang getNhanVienGiaoHang() {
        return nhanVienGiaoHang;
    }

    public void setNhanVienGiaoHang(NhanVienGiaoHang nhanVienGiaoHang) {
        this.nhanVienGiaoHang = nhanVienGiaoHang;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
}
