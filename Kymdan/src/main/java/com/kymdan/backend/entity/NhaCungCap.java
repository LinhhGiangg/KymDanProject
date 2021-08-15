package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "nha_cung_cap")
public class NhaCungCap {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "ten", columnDefinition = "VARCHAR(250)")
    private String ten;

    @Column(name = "dia_chi", columnDefinition = "VARCHAR(250)")
    private String diaChi;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "so_dien_thoai", columnDefinition = "VARCHAR(20)")
    private String soDienThoai;

    // relationship

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<LoaiSanPham> danhSachLoaiSanPham;

    public NhaCungCap() {
    }

    public NhaCungCap(String ma, String ten, String diaChi, String email, String soDienThoai,
                      List<LoaiSanPham> danhSachLoaiSanPham) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.danhSachLoaiSanPham = danhSachLoaiSanPham;
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