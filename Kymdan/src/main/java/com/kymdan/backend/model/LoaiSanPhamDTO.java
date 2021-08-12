package com.kymdan.backend.model;

import java.time.LocalDate;

public class LoaiSanPhamDTO {
    private String ma;
    private String ten;
    private String moTa;
    private String hinh;
    private Integer luotXem;
    private LocalDate ngayTao;

    public LoaiSanPhamDTO() {
    }

    public LoaiSanPhamDTO(String ma, String ten, String moTa, String hinh, Integer luotXem, LocalDate ngayTao) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.hinh = hinh;
        this.luotXem = luotXem;
        this.ngayTao = ngayTao;
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

    public Integer getLuotXem() {
        return luotXem;
    }

    public void setLuotXem(Integer luotXem) {
        this.luotXem = luotXem;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
}
