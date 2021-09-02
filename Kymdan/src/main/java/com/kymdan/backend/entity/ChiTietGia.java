package com.kymdan.backend.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "chi_tiet_gia")
public class ChiTietGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "gia", columnDefinition = "INT")
    private Integer gia;

    @Column(name = "ngay_thay_doi", columnDefinition = "DATE")
    private LocalDate ngayThayDoi;

    @ManyToOne
    @JoinColumn(name = "ma_san_pham", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private NhanVien nhanVien;

    public ChiTietGia() {
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
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
