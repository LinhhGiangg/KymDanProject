package com.kymdan.backend.model;

public class TaiKhoanDTO {
    private String tenDangNhap;
    private String matKhau;
    private ThongTinDTO thongTinDTO;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String tenDangNhap, String matKhau, ThongTinDTO thongTinDTO) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.thongTinDTO = thongTinDTO;
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

    public ThongTinDTO getThongTinDTO() {
        return thongTinDTO;
    }

    public void setThongTinDTO(ThongTinDTO thongTinDTO) {
        this.thongTinDTO = thongTinDTO;
    }
}
