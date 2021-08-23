package com.kymdan.backend.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "chi_tiet_gio_hang")
public class ChiTietGioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "so_luong", columnDefinition = "INT")
    private Integer soLuong;

    @Column(name = "trang_thai", columnDefinition = "VARCHAR(50)")
    private String trangThai;

    // moi quan he

    @ManyToOne
    @JoinColumn(name = "ma_gio_hang", referencedColumnName = "ma", columnDefinition = "INT")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    public ChiTietGioHang() {
    }

    public ChiTietGioHang(Integer ma, Integer soLuong, String trangThai,
                          GioHang gioHang, SanPham sanPham) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.gioHang = gioHang;
        this.sanPham = sanPham;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
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
