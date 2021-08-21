import { Component, OnInit } from '@angular/core';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {TaoMoiLoaiComponent} from '../../nhan-vien/loai-san-pham/tao-moi-loai/tao-moi-loai.component';
import {SuaLoaiComponent} from '../../nhan-vien/loai-san-pham/sua-loai/sua-loai.component';
import {XoaLoaiComponent} from '../../nhan-vien/loai-san-pham/xoa-loai/xoa-loai.component';

@Component({
  selector: 'app-gio-hang',
  templateUrl: './gio-hang.component.html',
  styleUrls: ['./gio-hang.component.css']
})
export class GioHangComponent implements OnInit {
  public danhSachLoai = [new LoaiSanPham()];
  public thongBao;

  constructor(
    public loaiSanPhamService: LoaiSanPhamService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    this.loaiSanPhamService.xemTatCa().subscribe(
      (duLieu) => {
        this.danhSachLoai = duLieu;
      },
      () => {
      },
      () => {
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.danhSachLoai.length; i++) {
          this.danhSachLoai[i].moTa1 = this.danhSachLoai[i].moTa.split(',')[0];
          this.danhSachLoai[i].moTa2 = this.danhSachLoai[i].moTa.split(',')[1];
          this.danhSachLoai[i].moTa3 = this.danhSachLoai[i].moTa.split(',')[2];
        }
      });
  }

  taoMoi() {
    this.thongBao = '';
    const dialogRefAdd = this.dialog.open(TaoMoiLoaiComponent, {
      width: '750px',
      height: '690px',
      data: {thongTin : ''},
      disableClose: true
    });

    dialogRefAdd.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  sua(maLoai) {
    this.loaiSanPhamService.timBangMaLoai(maLoai).subscribe(
      (duLieu) => {
        this.taoFormSua(duLieu)
      },
      () => {
      },
      () => {
      });
  }

  taoFormSua(duLieu) {
    this.thongBao = '';
    const dialogRefEdit = this.dialog.open(SuaLoaiComponent, {
      width: '750px',
      height: '690px',
      data: {thongTin: duLieu},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xoa(ten) {
    this.thongBao = '';
    const dialogRefDelete = this.dialog.open(XoaLoaiComponent, {
      width: '690px',
      height: '180px',
      data: {thongTin: ten},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  view(maLoai) {
    this.router.navigate(['/danh-sach-san-pham', {thongTin: maLoai}]).then(() => {
    });
  }
}
