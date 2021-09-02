package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "nha_cung_cap")
public class NhaCungCap {
    @Id
    @Column(name = "ma", columnDefinition = "CHAR(10)")
    private String ma;

    @Column(name = "ten", columnDefinition = "VARCHAR(250)")
    private String ten;

    @Column(name = "dia_chi", columnDefinition = "VARCHAR(250)")
    private String diaChi;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "so_dien_thoai", columnDefinition = "VARCHAR(20)")
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap")
    @JsonBackReference
    private List<LoaiSanPham> danhSachLoaiSanPham;

    public NhaCungCap() {
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<LoaiSanPham> getDanhSachLoaiSanPham() {
        return danhSachLoaiSanPham;
    }

    public void setDanhSachLoaiSanPham(List<LoaiSanPham> danhSachLoaiSanPham) {
        this.danhSachLoaiSanPham = danhSachLoaiSanPham;
    }
}
