package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "loai_san_pham")
public class LoaiSanPham {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "ten", columnDefinition = "VARCHAR(250)")
    private String ten;

    @Column(name = "mo_ta", columnDefinition = "VARCHAR(250)")
    private String moTa;

    @Column(name = "hinh1", columnDefinition = "VARCHAR(250)")
    private String hinh1;

    @Column(name = "hinh2", columnDefinition = "VARCHAR(250)")
    private String hinh2;

    @Column(name = "hinh3", columnDefinition = "VARCHAR(250)")
    private String hinh3;

    @Column(name = "luong_mua", columnDefinition = "INT")
    private Integer luongMua;

    @Column(name = "ngay_tao", columnDefinition = "DATE")
    private LocalDate ngayTao;

    @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<SanPham> danhSachSanPham;

    @ManyToOne()
    @JoinColumn(name = "ma_nha_cung_cap", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private NhaCungCap nhaCungCap;

    public LoaiSanPham() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinh1() {
        return hinh1;
    }

    public void setHinh1(String hinh1) {
        this.hinh1 = hinh1;
    }

    public String getHinh2() {
        return hinh2;
    }

    public void setHinh2(String hinh2) {
        this.hinh2 = hinh2;
    }

    public String getHinh3() {
        return hinh3;
    }

    public void setHinh3(String hinh3) {
        this.hinh3 = hinh3;
    }

    public Integer getLuongMua() {
        return luongMua;
    }

    public void setLuongMua(Integer luongMua) {
        this.luongMua = luongMua;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
