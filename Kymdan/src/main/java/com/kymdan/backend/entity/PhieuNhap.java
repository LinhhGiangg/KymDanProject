package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "phieu_nhap")
public class PhieuNhap {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "ngay_tao", columnDefinition = "DATE")
    private LocalDate ngayTao;

    // moi quan he

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "VARCHAR(10)")
    private NhanVien nhanVien;

    @OneToOne(mappedBy = "phieuNhap")
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private DatHang datHang;

    @OneToMany(mappedBy = "phieuNhap", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietPhieuNhap> danhSachChiTietPhieuNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(String ma, LocalDate ngayTao, NhanVien nhanVien, DatHang datHang,
                     List<ChiTietPhieuNhap> danhSachChiTietPhieuNhap) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.nhanVien = nhanVien;
        this.datHang = datHang;
        this.danhSachChiTietPhieuNhap = danhSachChiTietPhieuNhap;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public DatHang getDatHang() {
        return datHang;
    }

    public void setDatHang(DatHang datHang) {
        this.datHang = datHang;
    }

    public List<ChiTietPhieuNhap> getDanhSachChiTietPhieuNhap() {
        return danhSachChiTietPhieuNhap;
    }

    public void setDanhSachChiTietPhieuNhap(List<ChiTietPhieuNhap> danhSachChiTietPhieuNhap) {
        this.danhSachChiTietPhieuNhap = danhSachChiTietPhieuNhap;
    }
}
