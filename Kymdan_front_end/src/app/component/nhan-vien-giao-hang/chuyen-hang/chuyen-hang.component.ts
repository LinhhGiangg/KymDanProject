import {Component, OnInit} from '@angular/core';
import {NhanVienService} from '../../../service/nhan-vien.service';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {XacNhanGiaoComponent} from '../xac-nhan-giao/xac-nhan-giao.component';

@Component({
  selector: 'app-chuyen-hang',
  templateUrl: './chuyen-hang.component.html',
  styleUrls: ['./chuyen-hang.component.css']
})
export class ChuyenHangComponent implements OnInit {
  public danhSach = [];
  public danhSachLoc = [];
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
    this.loc();
  }

  chuyenTrangThai(ma) {
    const dialogRef = this.dialog.open(XacNhanGiaoComponent, {
      width: '550px',
      height: '178px',
      data: {thongTin: ma},
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  loc() {
    this.danhSachLoc = [];
    this.nhanVienService.danhSachDonHang(this.nhanVien).subscribe(
      (duLieu) => {
        this.danhSach = duLieu;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.danhSach.length; i++) {
          if (this.danhSach[i].nhanVienGiaoHang != null && this.danhSach[i].nhanVienGiaoHang.ten === this.nhanVien) {
            this.danhSachLoc.push(this.danhSach[i])
          }
        }
      });
  }
}
