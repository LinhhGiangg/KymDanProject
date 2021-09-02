import {Component, OnInit} from '@angular/core';
import {LoaiSanPhamService} from '../../../../service/loai-san-pham.service';
import {LoaiSanPham} from '../../../../model/LoaiSanPham';
import {MatDialog} from '@angular/material/dialog';
import {TaoMoiLoaiComponent} from '../tao-moi-loai/tao-moi-loai.component';
import {SuaLoaiComponent} from '../sua-loai/sua-loai.component';
import {XoaLoaiComponent} from '../xoa-loai/xoa-loai.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-quan-ly-loai',
  templateUrl: './quan-ly-loai.component.html',
  styleUrls: ['./quan-ly-loai.component.css']
})
export class QuanLyLoaiComponent implements OnInit {
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
      height: '645px',
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
      width: '715px',
      height: '180px',
      data: {thongTin: ten},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xemChiTiet(maLoai) {
    this.router.navigate(['/danh-sach-san-pham', {thongTin: maLoai}]).then(() => {
    });
  }
}
