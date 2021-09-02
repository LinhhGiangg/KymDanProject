package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "phieu_tra")
public class PhieuTra {
    @Id
    @Column(name = "ma", columnDefinition = "CHAR(10)")
    private String ma;

    @Column(name = "ngay_tra", columnDefinition = "DATE")
    private LocalDate ngayTra;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "ma_hoa_don", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private HoaDon hoaDon;

    @OneToMany(mappedBy = "phieuTra", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietPhieuTra> danhSachChiTietPhieuTra;

    public PhieuTra() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public LocalDate getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public List<ChiTietPhieuTra> getDanhSachChiTietPhieuTra() {
        return danhSachChiTietPhieuTra;
    }

    public void setDanhSachChiTietPhieuTra(List<ChiTietPhieuTra> danhSachChiTietPhieuTra) {
        this.danhSachChiTietPhieuTra = danhSachChiTietPhieuTra;
    }
}
