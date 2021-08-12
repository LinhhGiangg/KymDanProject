package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_dat_hang")
public class ChiTietDatHang {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "so_luong", columnDefinition = "VARCHAR(5)")
    private String soLuong;

    // relationship

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_dat_hang", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private DatHang datHang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    public ChiTietDatHang() {
    }

    public ChiTietDatHang(String ma, String soLuong, DatHang datHang, SanPham sanPham) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.datHang = datHang;
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
