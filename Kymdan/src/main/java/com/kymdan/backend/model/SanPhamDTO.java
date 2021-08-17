package com.kymdan.backend.model;

public class SanPhamDTO {
    private String ma;
    private String maLoai;
    private String kichThuoc;
    private String doDay;
    private String gia;
    private String soLuong;
    private String giamGia;

    public SanPhamDTO() {
    }

    public SanPhamDTO(String ma, String maLoai, String kichThuoc, String doDay, String gia, String soLuong,
                      String giamGia) {
        this.ma = ma;
        this.maLoai = maLoai;
        this.kichThuoc = kichThuoc;
        this.doDay = doDay;
        this.gia = gia;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getDoDay() {
        return doDay;
    }

    public void setDoDay(String doDay) {
        this.doDay = doDay;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }
}
