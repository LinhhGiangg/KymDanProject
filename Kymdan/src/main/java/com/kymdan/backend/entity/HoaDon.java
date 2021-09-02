package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "hoa_don")
public class HoaDon {
    @Id
    @Column(name = "ma", columnDefinition = "CHAR(10)")
    private String ma;

    @Column(name = "ma_so_thue", columnDefinition = "CHAR(10)")
    private String maSoThue;

    @Column(name = "ngay_tao", columnDefinition = "DATE")
    private LocalDate ngayTao;

    @Column(name = "tong_tien", columnDefinition = "INT")
    private Integer tongTien;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private NhanVien nhanVien;

    @OneToOne
    @JoinColumn(name = "ma_don_hang", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private DonHang donHang;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<PhieuTra> danhSachPhieuTra;

    public HoaDon() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public List<PhieuTra> getDanhSachPhieuTra() {
        return danhSachPhieuTra;
    }

    public void setDanhSachPhieuTra(List<PhieuTra> danhSachPhieuTra) {
        this.danhSachPhieuTra = danhSachPhieuTra;
    }
}
