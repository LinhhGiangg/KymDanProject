import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {NhanVienService} from '../../../../service/nhan-vien.service';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';
import {PhanCongComponent} from '../phan-cong/phan-cong.component';

@Component({
  selector: 'app-danh-sach-don-hang',
  templateUrl: './danh-sach-don-hang.component.html',
  styleUrls: ['./danh-sach-don-hang.component.css']
})
export class DanhSachDonHangComponent implements OnInit {
  public danhSach = [];
  public danhSachLoc = [];
  public thongBao;
  public nhanVien;
  public phanLoai;

  constructor(
    public nhanVienService: NhanVienService,
    public taiKhoanService: TaiKhoanService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    this.phanLoai = 'Tất cả';
    this.nhanVien = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    this.loc();
  }

  xemChiTietDonHang(ma) {
    const THONG_TIN = ma + ',' + this.nhanVien;
    this.router.navigate(['/chi-tiet-don-hang', {thongTin: THONG_TIN}]).then(() => {
    });
  }

  phanCongGiaoHang(ma) {
    const dialogRef = this.dialog.open(PhanCongComponent, {
      width: '750px',
      height: '390px',
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
        if (this.phanLoai === 'Tất cả') {
          this.danhSachLoc = this.danhSach;
        } else {
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.danhSach.length; i++) {
            if (this.danhSach[i].trangThai === this.phanLoai) {
              this.danhSachLoc.push(this.danhSach[i])
            }
          }
        }
      });
  }
}
