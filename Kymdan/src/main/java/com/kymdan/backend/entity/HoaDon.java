package com.kymdan.backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "hoa_don")
public class HoaDon {
    @Id
    @Column(name = "ma", columnDefinition = "VARCHAR(10)")
    private String ma;

    @Column(name = "ngay_tao", columnDefinition = "DATE")
    private LocalDate ngayTao;

    @Column(name = "tong_tien", columnDefinition = "VARCHAR(15)")
    private String tongTien;

    // relationship

    @OneToOne(mappedBy = "hoaDon")
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private DonHang donHang;

    public HoaDon() {
    }

    public HoaDon(String ma, LocalDate ngayTao, String tongTien, DonHang donHang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.donHang = donHang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
}
