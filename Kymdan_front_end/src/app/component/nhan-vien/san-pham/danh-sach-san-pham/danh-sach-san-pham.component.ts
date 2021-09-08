import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {SanPham} from '../../../../model/SanPham';
import {SanPhamService} from '../../../../service/san-pham.service';
import {XoaSanPhamComponent} from '../xoa-san-pham/xoa-san-pham.component';
import {SuaSanPhamComponent} from '../sua-san-pham/sua-san-pham.component';
import {ThemSanPhamComponent} from '../them-san-pham/them-san-pham.component';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';

@Component({
  selector: 'app-danh-sach-san-pham',
  templateUrl: './danh-sach-san-pham.component.html',
  styleUrls: ['./danh-sach-san-pham.component.css']
})
export class DanhSachSanPhamComponent implements OnInit {
  public danhSach = [new SanPham()];
  public thongBao;
  public maLoai;
  public tenLoai;
  public quyen = '';

  constructor(
    public taiKhoanService: TaiKhoanService,
    public sanPhamService: SanPhamService,
    public dialog: MatDialog,
    public router: Router,
    public activatedRouter: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
      this.activatedRouter.params.subscribe(duLieu => {
        this.maLoai = duLieu.thongTin;
      });

      this.sanPhamService.locTheoMaLoai(this.maLoai).subscribe(
        (duLieu) => {
          this.danhSach = duLieu;
        },
        () => {
        },
        () => {
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.danhSach.length; i++) {
            this.sanPhamService.timGiaBangMaSanPham(this.danhSach[i].ma).subscribe(
              (duLieu) => {
                this.danhSach[i].gia = duLieu.gia;
                this.danhSach[i].giaHienThi = this.sanPhamService.tienHienThi(this.danhSach[i].gia);
              },
              () => {
              },
              () => {
              });
          }
          if (this.danhSach.length > 0) {
            this.tenLoai = this.danhSach[0].loaiSanPham.ten;
          }
        });
    }
  }

  taoMoi() {
    this.thongBao = '';
    const dialogRefAdd = this.dialog.open(ThemSanPhamComponent, {
      width: '750px',
      height: '405px',
      data: {thongTin: this.maLoai},
      disableClose: true
    });

    dialogRefAdd.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  sua(ma) {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.danhSach.length; i++) {
      if (this.danhSach[i].ma === ma) {
        this.taoFormSua(this.danhSach[i]);
        break;
      }
    }
  }

  taoFormSua(duLieu) {
    this.thongBao = '';
    const dialogRefEdit = this.dialog.open(SuaSanPhamComponent, {
      width: '750px',
      height: '375px',
      data: {thongTin: duLieu},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xoa(ma) {
    this.thongBao = '';
    const dialogRefDelete = this.dialog.open(XoaSanPhamComponent, {
      width: '715px',
      height: '175px',
      data: {thongTin: ma + ',' + this.maLoai},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit()
    })
  }
}
