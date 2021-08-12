package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity(name = "nhan_vien")
public class NhanVien {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "ten", columnDefinition = "VARCHAR(50)")
    private String ten;

    @Column(name = "gioi_tinh", columnDefinition = "VARCHAR(5)")
    private String gioiTinh;

    @Column(name = "ngay_sinh", columnDefinition = "DATE")
    private LocalDate ngaySinh;

    @Column(name = "dia_chi", columnDefinition = "VARCHAR(250)")
    private String diaChi;

    @Column(name = "so_dien_thoai", columnDefinition = "VARCHAR(20)")
    private String soDienThoai;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    // relationship

    @OneToOne(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<DonHang> danhSachDonHang;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<KhuyenMai> danhSachKhuyenMai;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<PhieuNhap> danhSachPhieuNhap;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String gioiTinh, LocalDate ngaySinh, String diaChi, String soDienThoai,
                    String email, TaiKhoan taiKhoan, List<DonHang> danhSachDonHang, List<KhuyenMai> danhSachKhuyenMai,
                    List<PhieuNhap> danhSachPhieuNhap) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.danhSachDonHang = danhSachDonHang;
        this.danhSachKhuyenMai = danhSachKhuyenMai;
        this.danhSachPhieuNhap = danhSachPhieuNhap;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public List<DonHang> getDanhSachDonHang() {
        return danhSachDonHang;
    }

    public void setDanhSachDonHang(List<DonHang> danhSachDonHang) {
        this.danhSachDonHang = danhSachDonHang;
    }

    public List<KhuyenMai> getDanhSachKhuyenMai() {
        return danhSachKhuyenMai;
    }

    public void setDanhSachKhuyenMai(List<KhuyenMai> danhSachKhuyenMai) {
        this.danhSachKhuyenMai = danhSachKhuyenMai;
    }

    public List<PhieuNhap> getDanhSachPhieuNhap() {
        return danhSachPhieuNhap;
    }

    public void setDanhSachPhieuNhap(List<PhieuNhap> danhSachPhieuNhap) {
        this.danhSachPhieuNhap = danhSachPhieuNhap;
    }
}
