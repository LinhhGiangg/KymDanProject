package com.kymdan.backend.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "chi_tiet_gia")
public class ChiTietGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "gia", columnDefinition = "VARCHAR(15)")
    private String gia;

    @Column(name = "ngay_thay_doi", columnDefinition = "DATE")
    private LocalDate ngayThayDoi;

    // moi quan he

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private NhanVien nhanVien;

    public ChiTietGia() {
    }

    public ChiTietGia(Integer ma, String gia, LocalDate ngayThayDoi, SanPham sanPham, NhanVien nhanVien) {
        this.ma = ma;
        this.gia = gia;
        this.ngayThayDoi = ngayThayDoi;
        this.sanPham = sanPham;
        this.nhanVien = nhanVien;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public LocalDate getNgayThayDoi() {
        return ngayThayDoi;
    }

    public void setNgayThayDoi(LocalDate ngayThayDoi) {
        this.ngayThayDoi = ngayThayDoi;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
