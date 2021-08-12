package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_don_hang")
public class ChiTietDonHang {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "so_luong", columnDefinition = "VARCHAR(5)")
    private String soLuong;

    @Column(name = "gia", columnDefinition = "VARCHAR(15)")
    private String gia;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_don_hang", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private DonHang donHang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String ma, String soLuong, String gia, DonHang donHang, SanPham sanPham) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.gia = gia;
        this.donHang = donHang;
        this.sanPham = sanPham;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
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

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
