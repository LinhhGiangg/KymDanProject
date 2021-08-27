import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {MatDialog} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {SanPhamService} from '../../../../service/san-pham.service';
import {ThemSanPhamKhuyenMaiComponent} from '../them-san-pham-khuyen-mai/them-san-pham-khuyen-mai.component';

@Component({
  selector: 'app-chi-tiet-khuyen-mai',
  templateUrl: './chi-tiet-khuyen-mai.component.html',
  styleUrls: ['./chi-tiet-khuyen-mai.component.css']
})
export class ChiTietKhuyenMaiComponent implements OnInit {
  public maKhuyenMai;
  public danhSach = [];
  public kiemTra = false;
  public ngayHienTai = new Date();

  constructor(
    public khuyenMaiService: KhuyenMaiService,
    public sanPhamService: SanPhamService,
    public formBuilder: FormBuilder,
    public router: Router,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.kiemTra = false;
    this.activatedRouter.params.subscribe(duLieu => {
      this.maKhuyenMai = duLieu.thongTin;
    });

    this.khuyenMaiService.timChiTietBangMaKhuyenMai(this.maKhuyenMai)
      .subscribe(ketQua => {
          this.danhSach = ketQua;
        },
        () => {
        },
        () => {
          if (this.danhSach.length > 0) {
            // tslint:disable-next-line:prefer-for-of
            for (let i = 0; i < this.danhSach.length; i++) {
              this.sanPhamService.timGiaBangMaSanPham(this.danhSach[i].sanPham.ma).subscribe(
                (duLieu) => {
                  this.danhSach[i].gia = duLieu.gia;
                  this.danhSach[i].gia = this.sanPhamService.hienThiGia(this.danhSach[i].gia);
                },
                () => {
                },
                () => {
                });
            }

            if (Date.parse(this.danhSach[0].khuyenMai.ngayKetThuc) > Date.parse(this.ngayHienTai.toDateString())) {
              this.kiemTra = true;
            }
          }
        });
  }

  themSanPham() {
    const dialogRefAdd = this.dialog.open(ThemSanPhamKhuyenMaiComponent, {
      width: '750px',
      height: '268px',
      data: {thongTin: this.maKhuyenMai},
      disableClose: true
    });

    dialogRefAdd.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }
}
