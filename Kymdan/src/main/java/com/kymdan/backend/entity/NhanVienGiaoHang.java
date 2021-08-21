package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "nhan_vien_giao_hang")
public class NhanVienGiaoHang {
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

    @Column(name = "ten_cong_ty", columnDefinition = "VARCHAR(250)")
    private String tenCongTy;

    // moi quan he

    @OneToOne(mappedBy = "nhanVienGiaoHang", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "nhanVienGiaoHang")
    @JsonBackReference
    private List<DonHang> danhSachDonHang;

    public NhanVienGiaoHang() {
    }

    public NhanVienGiaoHang(String ma, String ten, String gioiTinh, LocalDate ngaySinh, String diaChi,
                            String soDienThoai, String email, String tenCongTy, TaiKhoan taiKhoan,
                            List<DonHang> danhSachDonHang) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.tenCongTy = tenCongTy;
        this.taiKhoan = taiKhoan;
        this.danhSachDonHang = danhSachDonHang;
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

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }
}
