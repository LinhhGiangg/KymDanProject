package com.kymdan.backend.model;

public class TaiKhoanHienTaiDTO {
    private Integer ma;
    private String tenDangNhap;
    private String token;
    private String hoTen;
    private String quyen;

    public TaiKhoanHienTaiDTO() {
    }

    public TaiKhoanHienTaiDTO(Integer ma, String tenDangNhap, String token, String hoTen, String quyen) {
        this.ma = ma;
        this.tenDangNhap = tenDangNhap;
        this.token = token;
        this.hoTen = hoTen;
        this.quyen = quyen;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
}
