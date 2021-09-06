import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {KhuyenMaiService} from '../../../../service/khuyen-mai.service';
import {MatDialog} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {SanPhamService} from '../../../../service/san-pham.service';
import {ThemSanPhamKhuyenMaiComponent} from '../them-san-pham-khuyen-mai/them-san-pham-khuyen-mai.component';
import {SuaSanPhamKhuyenMaiComponent} from '../sua-san-pham-khuyen-mai/sua-san-pham-khuyen-mai.component';
import {XoaSanPhamKhuyenMaiComponent} from '../xoa-san-pham-khuyen-mai/xoa-san-pham-khuyen-mai.component';
import {TaiKhoanService} from '../../../../service/tai-khoan.service';

@Component({
  selector: 'app-chi-tiet-khuyen-mai',
  templateUrl: './chi-tiet-khuyen-mai.component.html',
  styleUrls: ['./chi-tiet-khuyen-mai.component.css']
})
export class ChiTietKhuyenMaiComponent implements OnInit {
  public maKhuyenMai;
  public tenKhuyenMai;
  public danhSach = [];
  public kiemTra = false;
  public quyen = '';
  public ngayHienTai = new Date();

  constructor(
    public taiKhoanService: TaiKhoanService,
    public khuyenMaiService: KhuyenMaiService,
    public sanPhamService: SanPhamService,
    public formBuilder: FormBuilder,
    public router: Router,
    public activatedRouter: ActivatedRoute,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
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
                    this.danhSach[i].giaHienThi = this.sanPhamService.hienThiGia(this.danhSach[i].gia);
                  },
                  () => {
                  },
                  () => {
                  });
              }
              this.tenKhuyenMai = this.danhSach[0].khuyenMai.ten;

              if (Date.parse(this.danhSach[0].khuyenMai.ngayKetThuc) > Date.parse(this.ngayHienTai.toDateString())) {
                this.kiemTra = true;
              }
            }
          });
    }
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

  sua(maChiTiet) {
    let maSanPham;
    let giamGia;
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.danhSach.length; i++) {
      if (this.danhSach[i].ma === maChiTiet) {
        maSanPham = this.danhSach[i].sanPham.ma;
        giamGia = this.danhSach[i].giamGia;
      }
    }
    const dialogRefEdit = this.dialog.open(SuaSanPhamKhuyenMaiComponent, {
      width: '750px',
      height: '268px',
      data: {thongTin: this.maKhuyenMai + ',' + maChiTiet + ',' + maSanPham + ',' + giamGia},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }

  xoa(maChiTiet, maSanPham) {
    const dialogRefDelete = this.dialog.open(XoaSanPhamKhuyenMaiComponent, {
      width: '715px',
      height: '175px',
      data: {thongTin: this.maKhuyenMai + ',' + maChiTiet + ',' + maSanPham},
      disableClose: true
    });

    dialogRefDelete.afterClosed().subscribe(() => {
      this.ngOnInit();
    })
  }
}
