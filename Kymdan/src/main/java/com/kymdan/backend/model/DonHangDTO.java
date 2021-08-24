package com.kymdan.backend.model;

import java.time.LocalDate;

public class DonHangDTO {
    private String nguoiNhan;
    private String diaChi;
    private String soDienThoai;
    private LocalDate ngayNhan;
    private String cachThanhToan;

    private String sanPham;
    private String soLuong;
    private String gia;

    public DonHangDTO() {
    }

    public DonHangDTO(String nguoiNhan, String diaChi, String soDienThoai, LocalDate ngayNhan, String cachThanhToan,
                      String sanPham, String soLuong, String gia) {
        this.nguoiNhan = nguoiNhan;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngayNhan = ngayNhan;
        this.cachThanhToan = cachThanhToan;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getCachThanhToan() {
        return cachThanhToan;
    }

    public void setCachThanhToan(String cachThanhToan) {
        this.cachThanhToan = cachThanhToan;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
