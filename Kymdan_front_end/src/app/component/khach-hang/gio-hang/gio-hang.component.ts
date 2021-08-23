import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {KhachHangService} from '../../../service/khach-hang.service';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {ChiTietGioHang} from '../../../model/ChiTietGioHang';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {SanPhamService} from '../../../service/san-pham.service';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';

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
  public kiemTraMua;
  public danhSachMua = [];
  public maCanXoa;
  public tienCanThanhToan;

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
    this.kiemTraMua = false;
    this.maCanXoa = -1;
    this.maCanXoa = '';
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
            this.gioHang[i].chon = false;
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
        this.gioHang[i].tongTien = Number.parseInt(this.gioHang[i].gia) * this.gioHang[i].soLuong + '';
        this.gioHang[i].gia = GioHangComponent.hienThiGia(this.gioHang[i].gia);
        this.gioHang[i].tongTien = GioHangComponent.hienThiGia(this.gioHang[i].tongTien);
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
    let gia = '';
    this.tienCanThanhToan = 0;
    this.kiemTraMua = true;
    this.gioHang[i].chon = true;
    this.danhSachMua.push(this.gioHang[i]);

    // tslint:disable-next-line:prefer-for-of
    for (let z = 0; z < this.danhSachMua.length; z++) {
      gia = this.danhSachMua[z].tongTien.split('.')[0]
        + this.danhSachMua[z].tongTien.split('.')[1] + this.danhSachMua[z].tongTien.split('.')[2] + '';
      // tslint:disable-next-line:radix
      this.tienCanThanhToan = this.tienCanThanhToan + Number.parseInt(gia);
    }
    this.tienCanThanhToan = GioHangComponent.hienThiGia(this.tienCanThanhToan);
  }

  boChonSanPham(i: number) {
    let gia = '';
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
      gia = this.danhSachMua[z].tongTien.split('.')[0]
        + this.danhSachMua[z].tongTien.split('.')[1] + this.danhSachMua[z].tongTien.split('.')[2] + '';
      // tslint:disable-next-line:radix
      this.tienCanThanhToan = this.tienCanThanhToan + Number.parseInt(gia);
    }
    this.tienCanThanhToan = GioHangComponent.hienThiGia(this.tienCanThanhToan);
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
          // tslint:disable-next-line:radix
          if (this.gioHang[viTri].soLuong < Number.parseInt(duLieu.soLuong)) {
            // tslint:disable-next-line:radix
            this.gioHang[viTri].soLuong = Number.parseInt(String(this.gioHang[viTri].soLuong)) + 1;
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
  }
}
