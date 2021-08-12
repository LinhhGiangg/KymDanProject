package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_khuyen_mai")
public class ChiTietKhuyenMai {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "giam_gia", columnDefinition = "VARCHAR(5)")
    private String giamGia;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_khuyen_mai", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private KhuyenMai khuyenMai;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_loai_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private LoaiSanPham loaiSanPham;

    public ChiTietKhuyenMai() {
    }

    public ChiTietKhuyenMai(String ma, String giamGia, KhuyenMai khuyenMai, LoaiSanPham loaiSanPham) {
        this.ma = ma;
        this.giamGia = giamGia;
        this.khuyenMai = khuyenMai;
        this.loaiSanPham = loaiSanPham;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}
