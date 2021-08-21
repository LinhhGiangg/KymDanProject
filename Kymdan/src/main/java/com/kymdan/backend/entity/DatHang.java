package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "dat_hang")
public class DatHang {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "ngay_dat", columnDefinition = "DATE")
    private LocalDate ngayDat;

    // moi quan he

    @OneToOne
    @JoinColumn(name = "ma_phieu_nhap", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private PhieuNhap phieuNhap;

    @OneToMany(mappedBy = "datHang", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietDatHang> danhSachChiTietDatHang;

    public DatHang() {
    }

    public DatHang(String ma, LocalDate ngayDat, PhieuNhap phieuNhap, List<ChiTietDatHang> danhSachChiTietDatHang) {
        this.ma = ma;
        this.ngayDat = ngayDat;
        this.phieuNhap = phieuNhap;
        this.danhSachChiTietDatHang = danhSachChiTietDatHang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public List<ChiTietDatHang> getDanhSachChiTietDatHang() {
        return danhSachChiTietDatHang;
    }

    public void setDanhSachChiTietDatHang(List<ChiTietDatHang> danhSachChiTietDatHang) {
        this.danhSachChiTietDatHang = danhSachChiTietDatHang;
    }
}
