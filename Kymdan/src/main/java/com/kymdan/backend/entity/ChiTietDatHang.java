package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_dat_hang")
public class ChiTietDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "so_luong", columnDefinition = "VARCHAR(5)")
    private String soLuong;

    // moi quan he

    @ManyToOne
    @JoinColumn(name = "ma_dat_hang", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private DatHang datHang;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    public ChiTietDatHang() {
    }

    public ChiTietDatHang(Integer ma, String soLuong, DatHang datHang, SanPham sanPham) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.datHang = datHang;
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

    public DatHang getDatHang() {
        return datHang;
    }

    public void setDatHang(DatHang datHang) {
        this.datHang = datHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
