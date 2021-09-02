package com.kymdan.backend.model;

import java.time.LocalDate;

public class LoaiSanPhamDTO {
    private String ma;
    private String ten;
    private String moTa;
    private String hinh;
    private Integer luotMua;
    private LocalDate ngayTao;

    public LoaiSanPhamDTO() {
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

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getLuotMua() {
        return luotMua;
    }

    public void setLuotMua(Integer luotMua) {
        this.luotMua = luotMua;
    }
}
