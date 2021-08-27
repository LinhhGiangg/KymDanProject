import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {NhanVienService} from '../../../../service/nhan-vien.service';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';

@Component({
  selector: 'app-danh-sach-don-hang',
  templateUrl: './danh-sach-don-hang.component.html',
  styleUrls: ['./danh-sach-don-hang.component.css']
})
export class DanhSachDonHangComponent implements OnInit {
  public gioHang = [];
  public thongBao;
  public nhanVien;

  constructor(
    public nhanVienService: NhanVienService,
    public taiKhoanService: TaiKhoanService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    this.nhanVien = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    this.nhanVienService.danhSachDonHang(this.nhanVien).subscribe(
      (duLieu) => {
        this.gioHang = duLieu;
      },
      () => {
      },
      () => {
      });
  }

  xemChiTietDonHang(ma) {
    const THONG_TIN = ma + ',' + this.nhanVien;
    this.router.navigate(['/chi-tiet-don-hang', {thongTin: THONG_TIN}]).then(() => {
    });
  }
}
