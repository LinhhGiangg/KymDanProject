package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "quyen")
public class Quyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "ten", columnDefinition = "VARCHAR(50)")
    private String ten;

    // moi quan he

    @OneToMany(mappedBy = "quyen")
    @JsonBackReference
    private List<TaiKhoan> danhSachTaiKhoan;

    public Quyen() {
    }

    public Quyen(Integer ma, String ten, List<TaiKhoan> danhSachTaiKhoan) {
        this.ma = ma;
        this.ten = ten;
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    public void setDanhSachTaiKhoan(List<TaiKhoan> danhSachTaiKhoan) {
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }
}
