package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_gio_hang")
public class ChiTietGioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    // moi quan he

    @ManyToOne
    @JoinColumn(name = "ma_gio_hang", referencedColumnName = "ma", columnDefinition = "INT")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    public ChiTietGioHang() {
    }

    public ChiTietGioHang(Integer ma, GioHang gioHang, SanPham sanPham) {
        this.ma = ma;
        this.gioHang = gioHang;
        this.sanPham = sanPham;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
