import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {ThemKhuyenMaiComponent} from '../them-khuyen-mai/them-khuyen-mai.component';
import {SuaKhuyenMaiComponent} from '../sua-khuyen-mai/sua-khuyen-mai.component';
import {XoaKhuyenMaiComponent} from '../xoa-khuyen-mai/xoa-khuyen-mai.component';
import {ChiTietKhuyenMai} from '../../../../model/ChiTietKhuyenMai';
import {ChiTietKhuyenMaiComponent} from '../chi-tiet-khuyen-mai/chi-tiet-khuyen-mai.component';

@Component({
  selector: 'app-danh-sach-khuyen-mai',
  templateUrl: './danh-sach-khuyen-mai.component.html',
  styleUrls: ['./danh-sach-khuyen-mai.component.css']
})
export class DanhSachKhuyenMaiComponent implements OnInit {
  public danhSach = [];
  public thongBao;

  constructor(
    public khuyenMaiService: KhuyenMaiService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    this.khuyenMaiService.xemTatCa().subscribe(
      (duLieu) => {
        this.danhSach = duLieu;
      },
      () => {
      },
      () => {
      });
  }

  taoMoi() {
    this.thongBao = '';
    const dialogRefAdd = this.dialog.open(ThemKhuyenMaiComponent, {
      width: '750px',
      height: '500px',
      data: {thongTin: ''},
      disableClose: true
    });

    dialogRefAdd.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  sua(ma) {
    this.khuyenMaiService.timBangMa(ma).subscribe(
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
    const dialogRefEdit = this.dialog.open(SuaKhuyenMaiComponent, {
      width: '750px',
      height: '505px',
      data: {thongTin: duLieu},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xoa(ma) {
    this.thongBao = '';
    const dialogRefDelete = this.dialog.open(XoaKhuyenMaiComponent, {
      width: '690px',
      height: '180px',
      data: {thongTin: ma},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xemChiTiet(ma) {
    this.khuyenMaiService.timBangMa(ma).subscribe(
      (duLieu) => {
        this.taoFormXem(duLieu)
      },
      () => {
      },
      () => {
      });
  }

  taoFormXem(duLieu) {
    this.thongBao = '';
    const dialogRefEdit = this.dialog.open(ChiTietKhuyenMaiComponent, {
      width: '750px',
      height: '495px',
      data: {thongTin: duLieu},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }
}
