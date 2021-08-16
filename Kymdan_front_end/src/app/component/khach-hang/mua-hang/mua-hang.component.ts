import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TaiKhoanService} from '../../../service/tai-khoan.service';
import {MatDialog} from '@angular/material/dialog';
import {ThongBaoComponent} from '../../cau-hinh/thong-bao/thong-bao.component';
import {SanPham} from '../../../model/SanPham';
import {LoaiSanPham} from '../../../model/LoaiSanPham';
import {SanPhamService} from '../../../service/san-pham.service';
import {LoaiSanPhamService} from '../../../service/loai-san-pham.service';

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
  public soLuong = 1;
  public gia: string;
  public giaBan: string;
  public kichThuoc = '120x200';
  public doDay = '5';
  public sanPham = new SanPham();
  public loaiSanPham = new LoaiSanPham();

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
        this.soLuong = this.duLieuDauVao.split(',')[3];
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
    this.sanPhamService.sanPhamDauTien(thongTinSanPham).subscribe(
      (duLieu) => {
        this.sanPham = duLieu;
      },
      () => {
      },
      () => {
        if (this.sanPham != null) {
          // @ts-ignore
          this.gia = MuaHangComponent.hienThiGia(this.sanPham.gia);
          // tslint:disable-next-line:radix
          this.giaBan =
            // tslint:disable-next-line:radix
            (Number.parseInt(this.sanPham.gia) - (Number.parseInt(this.sanPham.gia) * Number.parseInt(this.sanPham.giamGia) / 100)) + '';
          // @ts-ignore
          this.giaBan = MuaHangComponent.hienThiGia(this.giaBan);
          this.kichThuoc = this.sanPham.rong + 'x200';
          this.doDay = this.sanPham.cao;
          this.thongTinSanPham = this.maLoai + ',' + this.sanPham.rong + ',' + this.sanPham.cao
        }
      });
  }

  chonKichThuoc(kichThuoc) {
    this.kichThuoc = kichThuoc;
    this.thongTinSanPham = this.maLoai + ',' + this.kichThuoc.split('x')[0] + ',' + this.doDay;
    this.chonSanPham(this.thongTinSanPham)
  }

  chonDoDay(doDay) {
    this.doDay = doDay;
    this.thongTinSanPham = this.maLoai + ',' + this.kichThuoc.split('x')[0] + ',' + this.doDay;
    this.chonSanPham(this.thongTinSanPham)
  }

  chonSanPham(thongTinSanPham) {
    this.sanPhamService.chonSanPham(thongTinSanPham).subscribe(
      (duLieu) => {
        this.sanPham = duLieu;
      },
      () => {
      },
      () => {
        if (this.sanPham != null) {
          // @ts-ignore
          this.gia = MuaHangComponent.hienThiGia(this.sanPham.gia);
          // tslint:disable-next-line:radix
          this.giaBan =
            // tslint:disable-next-line:radix
            (Number.parseInt(this.sanPham.gia) - (Number.parseInt(this.sanPham.gia) * Number.parseInt(this.sanPham.giamGia) / 100)) + '';
          // @ts-ignore
          this.giaBan = MuaHangComponent.hienThiGia(this.giaBan);
          this.kichThuoc = this.sanPham.rong + 'x200';
          this.doDay = this.sanPham.cao;
        } else {
          this.hienThongBao('Sản phẩm này hiện tại đang hết hàng ! Vui lòng chọn sản phẩm khác !');
          this.sanPhamDauTien(this.maLoai)
        }
      });
  }

  chonSoLuong(soLuong) {
    if (soLuong === 1) {
      if (this.soLuong >= 2) {
        this.soLuong = this.soLuong - 1;
      }
    } else {
      // tslint:disable-next-line:radix
      if (this.soLuong < Number.parseInt(this.sanPham.soLuong)) {
        this.soLuong = this.soLuong + 1;
      } else {
        this.hienThongBao('Hiện tại mặt hàng này chỉ còn ' + this.sanPham.soLuong + ' sản phẩm !')
      }
    }
  }

  luuGioHang() {
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
    const THONG_TIN = this.tenDangNhap + ',' + this.thongTinSanPham + ',' + this.soLuong;
    this.router.navigate(['/dat-hang', {thongTin: THONG_TIN}]).then(() => {
    });
  }
}
