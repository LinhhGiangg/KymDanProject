import {Component, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {NhanVienService} from '../../../../service/nhan-vien.service';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';
import {ThongKe} from '../../../../model/thong-ke';
import {ActivatedRoute} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {ChonNgayComponent} from '../chon-ngay/chon-ngay.component';
import 'hammerjs';

@Component({
  selector: 'app-thong-ke',
  templateUrl: './thong-ke.component.html',
  styleUrls: ['./thong-ke.component.css']
})
export class ThongKeComponent implements OnInit {
  public quyen;
  public kiemTra;
  public nhanVien;
  public duLieuDauVao;
  public ngayBatDauHienThi;
  public ngayKetThucHienThi;
  public doanhThu = [];
  public ngay = [];
  public duLieu = [];
  public thongTin = new ThongKe();
  public ngayHienTai = new Date();

  @ViewChild('container', {read: ViewContainerRef, static: true})
  public popupSettings: any;
  public container: ViewContainerRef;

  constructor(
    public nhanVienService: NhanVienService,
    public taiKhoanService: TaiKhoanService,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
    container: ViewContainerRef
  ) {
    this.popupSettings = { appendTo: this.container };
  }

  ngOnInit(): void {
    this.duLieuDauVao = '';
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
      this.nhanVien = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;

      this.activatedRouter.params.subscribe(duLieu => {
        if (duLieu.thongTin !== undefined) {
          this.kiemTra = true;
          this.duLieuDauVao = duLieu.thongTin + '';

          this.thongTin.ngayBatDau = new Date(this.duLieuDauVao.split(',')[0]);
          this.ngayBatDauHienThi = this.thongTin.ngayBatDau.getDate() + '/' + (this.thongTin.ngayBatDau.getMonth() + 1)
            + '/' + this.thongTin.ngayBatDau.getFullYear();

          this.thongTin.ngayKetThuc = new Date(duLieu.thongTin.split(',')[1]);
          this.ngayKetThucHienThi = this.thongTin.ngayKetThuc.getDate() + '/' + (this.thongTin.ngayKetThuc.getMonth() + 1)
            + '/' + this.thongTin.ngayKetThuc.getFullYear();
        } else {
          this.kiemTra = false;
          this.thongTin.ngayBatDau = new Date(this.ngayHienTai.setMonth((this.ngayHienTai.getMonth() - 6)));
          this.thongTin.ngayKetThuc = new Date();
        }
      });

      this.nhanVienService.thongKe(this.thongTin).subscribe(
        (duLieu) => {
          this.doanhThu = duLieu;
        },
        () => {
        },
        () => {
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.doanhThu.length; i++) {
            this.duLieu.push(this.doanhThu[i][0] / 1000000);
            this.ngay.push(this.doanhThu[i][1]);
          }
        });
    }
  }

  chonNgay() {
    const dialogRefAdd = this.dialog.open(ChonNgayComponent, {
      width: '777px',
      height: '262px',
      data: {thongTin: ''},
      disableClose: true
    });

    dialogRefAdd.afterClosed().subscribe(() => {
    })
  }
}
