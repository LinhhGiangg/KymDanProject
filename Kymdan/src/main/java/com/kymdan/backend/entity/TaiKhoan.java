package com.kymdan.backend.entity;

import javax.persistence.*;

@Entity(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma", columnDefinition = "INT")
    private Integer ma;

    @Column(name = "ten_dang_nhap", columnDefinition = "VARCHAR(50)")
    private String tenDangNhap;

    @Column(name = "mat_khau", columnDefinition = "VARCHAR(100)")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "ma_quyen", referencedColumnName = "ma", columnDefinition = "INT")
    private Quyen quyen;

    @OneToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private NhanVien nhanVien;

    @OneToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma", columnDefinition = "INT")
    private KhachHang khachHang;

    @OneToOne
    @JoinColumn(name = "ma_nhan_vien_giao_hang", referencedColumnName = "ma", columnDefinition = "CHAR(10)")
    private NhanVienGiaoHang nhanVienGiaoHang;

    public TaiKhoan() {
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVienGiaoHang getNhanVienGiaoHang() {
        return nhanVienGiaoHang;
    }

    public void setNhanVienGiaoHang(NhanVienGiaoHang nhanVienGiaoHang) {
        this.nhanVienGiaoHang = nhanVienGiaoHang;
    }
}
