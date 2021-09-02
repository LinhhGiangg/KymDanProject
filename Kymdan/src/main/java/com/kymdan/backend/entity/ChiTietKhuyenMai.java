package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_khuyen_mai")
public class ChiTietKhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "giam_gia", columnDefinition = "INT")
    private Integer giamGia;

    @ManyToOne
    @JoinColumn(name = "ma_khuyen_mai", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private SanPham sanPham;

    public ChiTietKhuyenMai() {
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Integer giamGia) {
        this.giamGia = giamGia;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
