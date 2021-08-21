package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_don_hang")
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "so_luong", columnDefinition = "VARCHAR(5)")
    private String soLuong;

    @Column(name = "gia", columnDefinition = "VARCHAR(15)")
    private String gia;

    // moi quan he

    @ManyToOne
    @JoinColumn(name = "ma_don_hang", referencedColumnName = "ma", columnDefinition = "INT")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(Integer ma, String soLuong, String gia, DonHang donHang, SanPham sanPham) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.gia = gia;
        this.donHang = donHang;
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
