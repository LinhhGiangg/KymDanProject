package com.kymdan.backend.model;

import java.time.LocalDate;

public class KhuyenMaiDTO {
    private String ma;
    private String ten;
    private String moTa;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String tenNhanVien;
    private String maSanPham;
    private String giamGia;

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String ma, String ten, String moTa, LocalDate ngayBatDau, LocalDate ngayKetThuc,
                        String tenNhanVien, String maSanPham, String giamGia) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tenNhanVien = tenNhanVien;
        this.maSanPham = maSanPham;
        this.giamGia = giamGia;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
}
