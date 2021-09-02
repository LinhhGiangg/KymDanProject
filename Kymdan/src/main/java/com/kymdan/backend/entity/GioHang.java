package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "gio_hang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @OneToMany(mappedBy = "gioHang", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ChiTietGioHang> danhSachGioHang;

    @OneToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma", columnDefinition = "INT")
    private KhachHang khachHang;

    public GioHang() {
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public List<ChiTietGioHang> getDanhSachGioHang() {
        return danhSachGioHang;
    }

    public void setDanhSachGioHang(List<ChiTietGioHang> danhSachGioHang) {
        this.danhSachGioHang = danhSachGioHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
