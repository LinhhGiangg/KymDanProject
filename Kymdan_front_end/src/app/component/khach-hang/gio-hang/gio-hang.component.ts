import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {KhachHangService} from '../../../service/khach-hang.service';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {ChiTietGioHang} from '../../../model/ChiTietGioHang';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {SanPhamService} from '../../../service/san-pham.service';

@Component({
  selector: 'app-gio-hang',
  templateUrl: './gio-hang.component.html',
  styleUrls: ['./gio-hang.component.css']
})
export class GioHangComponent implements OnInit {

  constructor(
    public taiKhoanService: TaiKhoanService,
    public khachHangService: KhachHangService,
    public loaiSanPhamService: LoaiSanPhamService,
    public sanPhamService: SanPhamService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  public gioHang = [new ChiTietGioHang()];
  public thongBao;
  public khachHang;
  public quyen;

  private static hienThiGia(thongTin) {
    let hangTrieu;
    let hangNgan;
    // tslint:disable-next-line:radix
    hangTrieu = (Number.parseInt(thongTin) / 1000000).toString().split('.')[0] + '';
    // tslint:disable-next-line:radix
    hangNgan = ((Number.parseInt(thongTin) - Number.parseInt(hangTrieu) * 1000000) / 1000).toString().split('.')[0] + '';
    if (hangNgan === '0') {
      return hangTrieu + '.000.000'
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 10) {
      return hangTrieu + '.00' + hangNgan + '.000';
      // tslint:disable-next-line:radix
    } else if (Number.parseInt(hangNgan) < 100) {
      return hangTrieu + '.0' + hangNgan + '.000';
    } else {
      return hangTrieu + '.' + hangNgan + '.000';
    }
  }

  ngOnInit(): void {
    this.khachHang = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
    if (this.quyen === 'Khách Hàng') {
      this.khachHangService.chiTietGioHang(this.khachHang).subscribe(
        (duLieu) => {
          this.gioHang = duLieu;
        },
        () => {
        },
        () => {
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.gioHang.length; i++) {
            this.thongTinSanPham(i);
            this.thongTinLoai(i);
            this.thongTinKhuyenMai(i);
            this.thongTinGia(i);
          }
        });
    }
  }

  private thongTinSanPham(i: number) {
    this.sanPhamService.timBangMa(this.gioHang[i].sanPham.ma).subscribe(
      (duLieu) => {
        this.gioHang[i].kichThuoc = duLieu.rong + ' x ' + duLieu.dai + ' x ' + duLieu.cao;
      },
      () => {
      },
      () => {
      });
  }

  private thongTinLoai(i: number) {
    this.loaiSanPhamService.timBangMaLoai(this.gioHang[i].sanPham.loaiSanPham.ma).subscribe(
      (duLieu) => {
        this.gioHang[i].maLoai = duLieu.ma;
        this.gioHang[i].ten = duLieu.ten;
        this.gioHang[i].hinh = duLieu.hinh1;
      },
      () => {
      },
      () => {
      });
  }

  private thongTinKhuyenMai(i: number) {
    this.sanPhamService.timKhuyenMaiBangMaSanPham(this.gioHang[i].sanPham.ma).subscribe(
      (duLieu) => {
        if (duLieu != null) {
          this.gioHang[i].khuyenMai = duLieu.giamGia;
        } else this.gioHang[i].khuyenMai = ''
      },
      () => {
      },
      () => {
      });
  }

  private thongTinGia(i: number) {
    this.sanPhamService.timGiaBangMaSanPham(this.gioHang[i].sanPham.ma).subscribe(
      (duLieu) => {
        this.gioHang[i].gia = duLieu.gia;
        if (this.gioHang[i].khuyenMai !== '') {
          // tslint:disable-next-line:radix
          this.gioHang[i].gia = (Number.parseInt(this.gioHang[i].gia)
            // tslint:disable-next-line:radix
            - Number.parseInt(this.gioHang[i].gia) * Number.parseInt(this.gioHang[i].khuyenMai) / 100) + '';
        }
        // tslint:disable-next-line:radix
        this.gioHang[i].tongTien = Number.parseInt(this.gioHang[i].gia) * Number.parseInt(this.gioHang[i].soLuong) + '';
        this.gioHang[i].gia = GioHangComponent.hienThiGia(this.gioHang[i].gia);
        this.gioHang[i].tongTien = GioHangComponent.hienThiGia(this.gioHang[i].tongTien);
      },
      () => {
      },
      () => {
      });
  }

  xoa(ma: number) {
    alert('xóa nha')
  }

  xemSanPham(i: number) {
    const THONG_TIN = this.gioHang[i].maLoai + ','
      + this.gioHang[i].kichThuoc.split(' x ')[0] + ',' + this.gioHang[i].kichThuoc.split(' x ')[2] + ',1';
    this.router.navigate(['/mua-hang', {thongTin: THONG_TIN}]).then(() => {
    });
  }
}
