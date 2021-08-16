package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


@Entity(name = "san_pham")
public class SanPham {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "dai", columnDefinition = "VARCHAR(5)")
    private String dai;

    @Column(name = "rong", columnDefinition = "VARCHAR(5)")
    private String rong;

    @Column(name = "cao", columnDefinition = "VARCHAR(5)")
    private String cao;

    @Column(name = "gia", columnDefinition = "VARCHAR(15)")
    private String gia;

    @Column(name = "so_luong", columnDefinition = "VARCHAR(5)")
    private String soLuong;

    @Column(name = "giam_gia", columnDefinition = "VARCHAR(5)")
    private String giamGia;

    // relationship

    @ManyToOne()
    @JoinColumn(name = "ma_loai_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private LoaiSanPham loaiSanPham;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietDonHang> danhSachChiTietDonHang;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietDatHang> danhSachChiTietDatHang;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietPhieuNhap> danhSachChiTietPhieuNhap;

    public SanPham() {
    }

    public SanPham(String ma, String dai, String rong, String cao, String gia, String soLuong, String giamGia,
                   LoaiSanPham loaiSanPham, List<ChiTietDonHang> danhSachChiTietDonHang,
                   List<ChiTietDatHang> danhSachChiTietDatHang, List<ChiTietPhieuNhap> danhSachChiTietPhieuNhap) {
        this.ma = ma;
        this.dai = dai;
        this.rong = rong;
        this.cao = cao;
        this.gia = gia;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
        this.loaiSanPham = loaiSanPham;
        this.danhSachChiTietDonHang = danhSachChiTietDonHang;
        this.danhSachChiTietDatHang = danhSachChiTietDatHang;
        this.danhSachChiTietPhieuNhap = danhSachChiTietPhieuNhap;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getDai() {
        return dai;
    }

    public void setDai(String dai) {
        this.dai = dai;
    }

    public String getRong() {
        return rong;
    }

    public void setRong(String rong) {
        this.rong = rong;
    }

    public String getCao() {
        return cao;
    }

    public void setCao(String cao) {
        this.cao = cao;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public List<ChiTietDonHang> getDanhSachChiTietDonHang() {
        return danhSachChiTietDonHang;
    }

    public void setDanhSachChiTietDonHang(List<ChiTietDonHang> danhSachChiTietDonHang) {
        this.danhSachChiTietDonHang = danhSachChiTietDonHang;
    }

    public List<ChiTietDatHang> getDanhSachChiTietDatHang() {
        return danhSachChiTietDatHang;
    }

    public void setDanhSachChiTietDatHang(List<ChiTietDatHang> danhSachChiTietDatHang) {
        this.danhSachChiTietDatHang = danhSachChiTietDatHang;
    }

    public List<ChiTietPhieuNhap> getDanhSachChiTietPhieuNhap() {
        return danhSachChiTietPhieuNhap;
    }

    public void setDanhSachChiTietPhieuNhap(List<ChiTietPhieuNhap> danhSachChiTietPhieuNhap) {
        this.danhSachChiTietPhieuNhap = danhSachChiTietPhieuNhap;
    }
}
