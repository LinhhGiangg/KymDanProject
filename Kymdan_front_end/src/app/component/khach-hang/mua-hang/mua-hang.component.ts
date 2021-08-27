import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {MatDialog} from '@angular/material/dialog';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';
import {SanPham} from '../../../model/SanPham';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {SanPhamService} from '../../../service/san-pham.service';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';
import {KhachHangService} from '../../../service/khach-hang.service';

@Component({
  selector: 'app-mua-hang',
  templateUrl: './mua-hang.component.html',
  styleUrls: ['./mua-hang.component.css']
})
export class MuaHangComponent implements OnInit {

  constructor(
    public activatedRouter: ActivatedRoute,
    public sanPhamService: SanPhamService,
    public loaiSanPhamService: LoaiSanPhamService,
    public taiKhoanService: TaiKhoanService,
    public khachHangService: KhachHangService,
    public router: Router,
    public dialog: MatDialog,
  ) {
  }

  public thongBao;
  public quyen = 'Nothing';
  public tenDangNhap;
  public maLoai = '';
  public duLieuDauVao;
  public thongTinSanPham;
  public soLuong: number;
  public gia = '';
  public giaBan = '';
  public kichThuoc = '120x200';
  public doDay = '5';
  public sanPham = new SanPham();
  public loaiSanPham = new LoaiSanPham();
  public chiTietGia = null;
  public chiTietKhuyenMai;

  ngOnInit(): void {
    this.soLuong = 1;
    if (this.taiKhoanService.thongTinNguoiDungHienTai != null) {
      this.quyen = this.taiKhoanService.thongTinNguoiDungHienTai.quyen;
      this.tenDangNhap = this.taiKhoanService.thongTinNguoiDungHienTai.tenDangNhap;
    }

    this.activatedRouter.params.subscribe(duLieu => {
      this.duLieuDauVao = duLieu.thongTin;
      this.maLoai = this.duLieuDauVao.split(',')[0];
      if (this.duLieuDauVao.split(',').length > 1) {
        this.thongTinSanPham =
          this.maLoai + ',' + this.duLieuDauVao.split(',')[1].split('x')[0] + ',' +
          this.duLieuDauVao.split(',')[2];
        this.chonSanPham(this.thongTinSanPham);
        // tslint:disable-next-line:radix
        this.soLuong = Number.parseInt(this.duLieuDauVao.split(',')[3]);
      } else {
        this.sanPhamDauTien(this.maLoai)
      }
    });

    this.loaiSanPhamService.timBangMaLoai(this.maLoai).subscribe(
      (duLieu) => {
        this.loaiSanPham = duLieu;
      },
      () => {
      },
      () => {
      });
  }

  sanPhamDauTien(thongTinSanPham) {
    this.gia = '';
    this.giaBan = '';
    this.sanPhamService.sanPhamDauTien(thongTinSanPham).subscribe(
      (duLieu) => {
        this.sanPham = duLieu;
      },
      () => {
      },
      () => {
        if (this.sanPham != null) {
          this.kichThuoc = this.sanPham.rong + 'x200';
          this.doDay = this.sanPham.cao;
          this.thongTinSanPham = this.maLoai + ',' + this.sanPham.rong + ',' + this.sanPham.cao;

          this.sanPhamService.timGiaBangMaSanPham(this.sanPham.ma).subscribe(
            (duLieu) => {
              this.chiTietGia = duLieu;
            },
            () => {
            },
            () => {
              this.gia = '';
              if (this.chiTietGia != null) {
                // @ts-ignore
                this.gia = this.sanPhamService.hienThiGia(this.chiTietGia.gia);

                this.sanPhamService.timKhuyenMaiBangMaSanPham(this.sanPham.ma).subscribe(
                  (duLieu) => {
                    this.chiTietKhuyenMai = duLieu;
                  },
                  () => {
                  },
                  () => {
                    this.giaBan = '';
                    if (this.chiTietKhuyenMai != null) {
                      // tslint:disable-next-line:radix
                      this.giaBan =
                        // tslint:disable-next-line:radix
                        (Number.parseInt(this.chiTietGia.gia) -
                          // tslint:disable-next-line:radix
                          (Number.parseInt(this.chiTietGia.gia) * Number.parseInt(this.chiTietKhuyenMai.giamGia) / 100)) + '';
                      // @ts-ignore
                      this.giaBan = this.sanPhamService.hienThiGia(this.giaBan);
                    }
                  });
              }
            });
        }
      });
  }

  chonSanPham(thongTinSanPham) {
    this.sanPhamService.chonSanPham(thongTinSanPham).subscribe(
      (duLieu) => {
        this.sanPham = duLieu;
      },
      () => {
      },
      () => {
        if (this.sanPham != null && this.sanPham.soLuong !== '0') {
          this.kichThuoc = this.sanPham.rong + 'x200';
          this.doDay = this.sanPham.cao;

          this.sanPhamService.timGiaBangMaSanPham(this.sanPham.ma).subscribe(
            (duLieu) => {
              this.chiTietGia = duLieu;
            },
            () => {
            },
            () => {
              this.gia = '';
              if (this.chiTietGia != null) {
                // @ts-ignore
                this.gia = this.sanPhamService.hienThiGia(this.chiTietGia.gia);

                this.sanPhamService.timKhuyenMaiBangMaSanPham(this.sanPham.ma).subscribe(
                  (duLieu) => {
                    this.chiTietKhuyenMai = duLieu;
                  },
                  () => {
                  },
                  () => {
                    this.giaBan = '';
                    if (this.chiTietKhuyenMai != null) {
                      // tslint:disable-next-line:radix
                      this.giaBan =
                        // tslint:disable-next-line:radix
                        (Number.parseInt(this.chiTietGia.gia) -
                          // tslint:disable-next-line:radix
                          (Number.parseInt(this.chiTietGia.gia) * Number.parseInt(this.chiTietKhuyenMai.giamGia) / 100)) + '';
                      // @ts-ignore
                      this.giaBan = this.sanPhamService.hienThiGia(this.giaBan);
                    }
                  });
              }
            });
        } else {
          this.hienThongBao('Sản phẩm này hiện tại đang hết hàng ! Vui lòng chọn sản phẩm khác !');
          this.sanPhamDauTien(this.maLoai)
        }
      });
  }

  chonKichThuoc(kichThuoc) {
    this.soLuong = 1;
    this.kichThuoc = kichThuoc;
    this.thongTinSanPham = this.maLoai + ',' + this.kichThuoc.split('x')[0] + ',' + this.doDay;
    this.chonSanPham(this.thongTinSanPham)
  }

  chonDoDay(doDay) {
    this.soLuong = 1;
    this.doDay = doDay;
    this.thongTinSanPham = this.maLoai + ',' + this.kichThuoc.split('x')[0] + ',' + this.doDay;
    this.chonSanPham(this.thongTinSanPham)
  }

  chonSoLuong(soLuong) {
    if (soLuong === 1) {
      if (this.soLuong >= 2) {
        this.soLuong = this.soLuong - 1;
      }
    } else {
      // tslint:disable-next-line:radix
      if (this.soLuong < Number.parseInt(this.sanPham.soLuong)) {
        // tslint:disable-next-line:radix
        this.soLuong = this.soLuong + 1;
      } else {
        this.hienThongBao('Hiện tại mặt hàng này chỉ còn ' + this.sanPham.soLuong + ' sản phẩm !')
      }
    }
  }

  luuGioHang() {
    this.khachHangService.luuGioHang(this.tenDangNhap, this.sanPham.ma, this.soLuong).subscribe(
      () => {
        this.hienThongBao('Thêm giỏ hàng thành công !')
      },
      () => {
      },
      () => {
      });
  }

  hienThongBao(thongBao) {
    this.thongBao = this.maLoai + ',' + thongBao + ',' + this.thongTinSanPham;
    const dialogRefNotice = this.dialog.open(ThongBaoComponent, {
      width: '555px',
      height: '205px',
      data: {thongBao: this.thongBao.split(',')[1]},
      disableClose: true
    });

    dialogRefNotice.afterClosed().subscribe(() => {
      if (this.thongBao.split(',')[1] === 'Cần đăng nhập trước khi mua sản phẩm !') {
        this.router.navigate(['/dang-nhap', {thongTin: this.thongTinSanPham + ',' + this.soLuong}]).then(() => {
        });
      }
    })
  }

  muaHang() {
    this.khachHangService.luuGioHang(this.tenDangNhap, this.sanPham.ma, this.soLuong).subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.khachHangService.timChiTietGioHang(this.sanPham.ma, this.tenDangNhap).subscribe(
          (duLieu) => {
            this.router.navigate(['/dat-hang', {thongTin: duLieu.sanPham.ma}]).then(() => {
            });
          },
          () => {
          },
          () => {
          });
      });
  }
}
