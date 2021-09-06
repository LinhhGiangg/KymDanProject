import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {KhachHangService} from '../../../service/khach-hang.service';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {ChiTietGioHang} from '../../../model/ChiTietGioHang';
import {SanPhamService} from '../../../service/san-pham.service';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

@Component({
  selector: 'app-gio-hang',
  templateUrl: './gio-hang.component.html',
  styleUrls: ['./gio-hang.component.css']
})
export class GioHangComponent implements OnInit {
  public gioHang = [new ChiTietGioHang()];
  public thongBao;
  public khachHang;
  public quyen = '';
  public kiemTraMua;
  public danhSachMua = [];
  public maCanXoa;
  public tienCanThanhToan;
  public tienCanThanhToanHienThi;

  constructor(
    public taiKhoanService: TaiKhoanService,
    public khachHangService: KhachHangService,
    public sanPhamService: SanPhamService,
    public dialog: MatDialog,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.kiemTraMua = false;
      this.maCanXoa = -1;
      this.danhSachMua = [];
      this.khachHang = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
      if (this.quyen === 'Khách Hàng') {
        this.khachHangService.danhSachChiTietGioHang(this.khachHang).subscribe(
          (duLieu) => {
            this.gioHang = duLieu;
          },
          () => {
          },
          () => {
            // tslint:disable-next-line:prefer-for-of
            for (let i = 0; i < this.gioHang.length; i++) {
              this.thongTinSanPham(i);
              this.thongTinKhuyenMai(i);
              this.gioHang[i].chon = false;
            }
          });
      }
    }
  }

  private thongTinSanPham(i: number) {
    this.gioHang[i].kichThuoc = this.gioHang[i].sanPham.rong + ' x ' + this.gioHang[i].sanPham.dai + ' x ' + this.gioHang[i].sanPham.cao;
    this.gioHang[i].maLoai = this.gioHang[i].sanPham.loaiSanPham.ma;
    this.gioHang[i].ten = this.gioHang[i].sanPham.loaiSanPham.ten;
    this.gioHang[i].hinh = this.gioHang[i].sanPham.loaiSanPham.hinh1;
  }

  private thongTinKhuyenMai(i: number) {
    this.sanPhamService.timKhuyenMaiBangMaSanPham(this.gioHang[i].sanPham.ma).subscribe(
      (duLieu) => {
        if (duLieu != null) {
          this.gioHang[i].khuyenMai = duLieu.giamGia;
        } else this.gioHang[i].khuyenMai = 0
      },
      () => {
      },
      () => {
        this.thongTinGia(i);
      });
  }

  private thongTinGia(i: number) {
    this.sanPhamService.timGiaBangMaSanPham(this.gioHang[i].sanPham.ma).subscribe(
      (duLieu) => {
        this.gioHang[i].gia = duLieu.gia;
        if (this.gioHang[i].khuyenMai !== 0) {
          this.gioHang[i].gia = this.gioHang[i].gia - this.gioHang[i].gia * this.gioHang[i].khuyenMai / 100;
        }
        this.gioHang[i].tongTien = this.gioHang[i].gia * this.gioHang[i].soLuong;
        this.gioHang[i].giaHienThi = this.sanPhamService.hienThiGia(this.gioHang[i].gia);
        this.gioHang[i].tongTienHienThi = this.sanPhamService.hienThiGia(this.gioHang[i].tongTien);
      },
      () => {
      },
      () => {
      });
  }

  xemSanPham(i: number) {
    const THONG_TIN = this.gioHang[i].maLoai + ','
      + this.gioHang[i].kichThuoc.split(' x ')[0] + ',' + this.gioHang[i].kichThuoc.split(' x ')[2] + ',1';
    this.router.navigate(['/mua-hang', {thongTin: THONG_TIN}]).then(() => {
    });
  }

  chonSanPham(i: number) {
    let gia = 0;
    this.tienCanThanhToan = 0;
    this.kiemTraMua = true;
    this.gioHang[i].chon = true;
    this.danhSachMua.push(this.gioHang[i]);

    // tslint:disable-next-line:prefer-for-of
    for (let z = 0; z < this.danhSachMua.length; z++) {
      gia = this.danhSachMua[z].tongTien;
      this.tienCanThanhToan = this.tienCanThanhToan + gia;
    }
    this.tienCanThanhToanHienThi = this.sanPhamService.hienThiGia(this.tienCanThanhToan);
  }

  boChonSanPham(i: number) {
    let gia = 0;
    this.tienCanThanhToan = 0;
    this.kiemTraMua = false;
    this.gioHang[i].chon = false;
    this.maCanXoa = this.gioHang[i].ma;
    // tslint:disable-next-line:prefer-for-of
    for (let j = 0; j < this.gioHang.length; j++) {
      if (this.gioHang[j].chon === true && this.kiemTraMua === false) {
        this.kiemTraMua = true;
        break;
      }
    }

    for (let z = 0; z < this.danhSachMua.length; z++) {
      if (this.danhSachMua[z].ma === this.maCanXoa) {
        this.danhSachMua.splice(z, 1);
      }
    }

    // tslint:disable-next-line:prefer-for-of
    for (let z = 0; z < this.danhSachMua.length; z++) {
      gia = this.danhSachMua[z].tongTien;
      this.tienCanThanhToan = this.tienCanThanhToan + gia;
    }
    this.tienCanThanhToanHienThi = this.sanPhamService.hienThiGia(this.tienCanThanhToan);
  }

  chonSoLuong(thayDoi, viTri) {
    this.sanPhamService.timBangMa(this.gioHang[viTri].sanPham.ma).subscribe(
      (duLieu) => {
        if (thayDoi === 1) {
          if (this.gioHang[viTri].soLuong >= 2) {
            this.gioHang[viTri].soLuong -= 1;
            this.khachHangService.thayDoiSanPham(this.gioHang[viTri].ma, this.gioHang[viTri].soLuong).subscribe(
              () => {
              },
              () => {
              },
              () => {
                this.ngOnInit()
              });
          }
        } else {
          if (this.gioHang[viTri].soLuong < duLieu.soLuong) {
            this.gioHang[viTri].soLuong = this.gioHang[viTri].soLuong + 1;
            this.khachHangService.thayDoiSanPham(this.gioHang[viTri].ma, this.gioHang[viTri].soLuong).subscribe(
              () => {
              },
              () => {
              },
              () => {
                this.ngOnInit()
              });
          } else {
            this.hienThongBao('Hiện tại mặt hàng này chỉ còn ' + duLieu.soLuong + ' sản phẩm !')
          }
        }
      },
      () => {
      },
      () => {
      });
  }

  hienThongBao(thongTin) {
    const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
      width: '555px',
      height: '205px',
      data: {thongBao: thongTin},
      disableClose: true
    });

    dialogRefNotice.afterClosed().subscribe(() => {
    })
  }

  xoa(ma: number) {
    this.khachHangService.xoaSanPham(ma).subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.ngOnInit()
      });
  }

  thanhToan() {
    let duLieu = '';
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.danhSachMua.length; i++) {
      if (i === 0) {
        duLieu += this.danhSachMua[i].sanPham.ma;
      } else {
        duLieu = duLieu + ',' + this.danhSachMua[i].sanPham.ma;
      }
    }
    this.router.navigate(['/dat-hang', {thongTin: duLieu}]).then(() => {
    });
  }
}
