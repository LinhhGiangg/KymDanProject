package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "khuyen_mai")
public class KhuyenMai {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "ten", columnDefinition = "VARCHAR(50)")
    private String ten;

    @Column(name = "ngay_bat_dau", columnDefinition = "DATE")
    private LocalDate ngayBatDau;

    @Column(name = "ngay_ket_thuc", columnDefinition = "DATE")
    private LocalDate ngayKetThuc;

    @Column(name = "mo_ta", columnDefinition = "VARCHAR(250)")
    private String moTa;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "khuyenMai", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietKhuyenMai> danhSachChiTietKhuyenMai;

    public KhuyenMai() {
    }

    public KhuyenMai(String ma, String ten, LocalDate ngayBatDau, LocalDate ngayKetThuc, String moTa, NhanVien nhanVien,
                     List<ChiTietKhuyenMai> danhSachChiTietKhuyenMai) {
        this.ma = ma;
        this.ten = ten;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTa = moTa;
        this.nhanVien = nhanVien;
        this.danhSachChiTietKhuyenMai = danhSachChiTietKhuyenMai;
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

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public List<ChiTietKhuyenMai> getDanhSachChiTietKhuyenMai() {
        return danhSachChiTietKhuyenMai;
    }

    public void setDanhSachChiTietKhuyenMai(List<ChiTietKhuyenMai> danhSachChiTietKhuyenMai) {
        this.danhSachChiTietKhuyenMai = danhSachChiTietKhuyenMai;
    }
}
