package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "chi_tiet_dat_hang")
public class ChiTietDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "so_luong", columnDefinition = "INT")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "ma_dat_hang", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private DatHang datHang;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private SanPham sanPham;

    public ChiTietDatHang() {
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
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
