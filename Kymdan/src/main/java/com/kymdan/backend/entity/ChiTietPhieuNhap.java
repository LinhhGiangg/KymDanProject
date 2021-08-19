package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_phieu_nhap")
public class ChiTietPhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "so_luong", columnDefinition = "VARCHAR(5)")
    private String soLuong;

    @Column(name = "gia", columnDefinition = "VARCHAR(15)")
    private String gia;

    // relationship

    @ManyToOne
    @JoinColumn(name = "ma_phieu_nhap", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private PhieuNhap phieuNhap;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(Integer ma, String soLuong, String gia, PhieuNhap phieuNhap, SanPham sanPham) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.gia = gia;
        this.phieuNhap = phieuNhap;
        this.sanPham = sanPham;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
